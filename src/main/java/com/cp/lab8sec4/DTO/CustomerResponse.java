package com.cp.lab8sec4.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CustomerResponse( //@RequestMapping, @GetMapping, @VariablePath CustomerResponse custRes
		@NotNull long id,
		@NotBlank String name,
		@Email String email) 
		{
	
}
