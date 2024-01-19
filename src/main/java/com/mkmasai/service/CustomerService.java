package com.mkmasai.service;

import java.util.List;



import com.mkmasai.exception.CustomerException;
import com.mkmasai.model.Customer;


public interface CustomerService {

	public Customer registerCustomer(Customer customer);
	
	public Customer getCustomerDetailsByEmail(String email)  throws CustomerException;
	
	public List<Customer> getAllCustomerDetails() throws CustomerException;
	
	
	
	
}
