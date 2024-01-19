package com.mkmasai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mkmasai.model.Customer;
import com.mkmasai.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired 
	private CustomerService customerService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@GetMapping("/hello")
	public String testHandler() {
		return "welcome to spring Security";
	}
	
	
	@PostMapping("/customers")
	public ResponseEntity<Customer> saveCustomerHandler(@RequestBody Customer customer){
		
		customer.setPassword(passwordEncoder.encode(customer.getPassword()));
		
		Customer registeredCustomer = customerService.registerCustomer(customer);
		
		return new ResponseEntity<>(registeredCustomer, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/customers/{email}")
	public ResponseEntity<Customer> getCustomerByEmailHandler(@PathVariable("email") String email) {
		
		Customer cus = customerService.getCustomerDetailsByEmail(email);

		return  new ResponseEntity<>(cus , HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomersDetailsHandler(){
		
		List<Customer> list = customerService.getAllCustomerDetails();
		
		return new ResponseEntity<>(list , HttpStatus.ACCEPTED);
		
	}
	
}
