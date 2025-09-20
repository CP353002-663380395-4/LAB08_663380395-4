package com.cp.lab8sec4.web;

import com.cp.lab8sec4.DTO.CustomerRequest;
import com.cp.lab8sec4.DTO.CustomerResponse;
import com.cp.lab8sec4.service.CustomerService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/customers")
public class CustomerRestController {
    
	@Autowired
    private CustomerService custService;
    
    @GetMapping
    public ResponseEntity<List<CustomerResponse>> getAllCustomer() {
        List<CustomerResponse> customers = custService.getCustomerList();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> getCustomerById(@PathVariable Long id) {
        CustomerResponse cust = custService.getCustomerById(id);
        return new ResponseEntity<>(cust, HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<?> addCustomer(@RequestBody @Valid CustomerRequest cust,
    		BindingResult br) {
    		if(br.hasErrors()) {
    			Map<String, Object> err = new LinkedHashMap<>();
    			err.put("status", 400);
    			err.put("error", "Bad Request");
    			err.put("message", "Validation failed");
    			err.put("fieldErrors", br.getFieldErrors().stream()
    					.map(fe->Map.of(
    							"field", fe.getField(),
    							"message", fe.getDefaultMessage(),
    							"rejectedValue", fe.getRejectedValue()
    							)).toList());
    			return ResponseEntity.badRequest().body(err);
    		}
    		else {
    			CustomerResponse response = custService.save(cust);
    			return new ResponseEntity<>(response, HttpStatus.OK);
    		}
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable Long id, 
    			@RequestBody @Valid CustomerRequest custReq,
    			BindingResult br) {
	    	if(br.hasErrors()) {
				Map<String, Object> err = new LinkedHashMap<>();
				err.put("status", 400);
				err.put("error", "Bad Request");
				err.put("message", "Validation failed");
				err.put("fieldErrors", br.getFieldErrors().stream()
						.map(fe->Map.of(
								"field", fe.getField(),
								"message", fe.getDefaultMessage(),
								"rejectedValue", fe.getRejectedValue()
								)).toList());
				return ResponseEntity.badRequest().body(err);
			}
			else {
				return new ResponseEntity<>(custService.updateCustomer(id, custReq), HttpStatus.OK);
			}
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomerById(@PathVariable Long id) {
        CustomerResponse custDel = custService.getCustomerById(id);
        if(custDel != null) {
        		custService.deleteCustomerById(id);
        		return new ResponseEntity<>("delete", HttpStatus.OK);
        }
        return new ResponseEntity<>("Customer doesnot Exist", HttpStatus.NOT_FOUND);
    }
}