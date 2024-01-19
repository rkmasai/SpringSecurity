package com.mkmasai.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mkmasai.model.Customer;
import com.mkmasai.repository.CustomerRepository;

@RestController
public class LoginController {

	@Autowired
	private CustomerRepository customerRepository;
	
//	@GetMapping("/signIn")
//	public ResponseEntity<Customer> getLoggedInCustomerDetailsHandler(Authentication auth) {
//	    try {
//	        Customer customer = customerRepository.findByEmail(auth.getName())
//	                .orElseThrow(() -> new BadCredentialsException("Customer not found"));
//
//	        return new ResponseEntity<>(customer, HttpStatus.OK);
//	    } catch (BadCredentialsException e) {
//	        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
//	    }
//	}
	
	@GetMapping("/signIn")
	public ResponseEntity<Customer> getLoggedInCustomerHandler(Authentication auth){
	Customer cus =	customerRepository.findByEmail(auth.getName()).orElseThrow(() ->  new BadCredentialsException(""));
	
	return new ResponseEntity<>(cus, HttpStatus.ACCEPTED);
	}
}
