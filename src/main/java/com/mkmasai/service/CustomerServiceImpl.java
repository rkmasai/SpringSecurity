package com.mkmasai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkmasai.exception.CustomerException;
import com.mkmasai.model.Customer;
import com.mkmasai.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository cusRepo;

	@Override
	public Customer registerCustomer(Customer customer) {
	
		return cusRepo.save(customer);
	}

	@Override
	public Customer getCustomerDetailsByEmail(String email) throws CustomerException {
		// TODO Auto-generated method stub
		return cusRepo.findByEmail(email).orElseThrow(() -> new CustomerException("Customer"));
	}

	@Override
	public List<Customer> getAllCustomerDetails() throws CustomerException {
		// TODO Auto-generated method stub
		
		List<Customer> list = cusRepo.findAll();
		
		if(list.isEmpty()) {
			throw new CustomerException("No Record Avaliable");
		}
		
		return list;
	}

}
