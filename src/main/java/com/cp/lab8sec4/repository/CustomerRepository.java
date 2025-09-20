package com.cp.lab8sec4.repository;

import org.springframework.data.repository.CrudRepository;

import com.cp.lab8sec4.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    
}