package com.mkmasai.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mkmasai.model.Customer;
import com.mkmasai.repository.CustomerRepository;
@Service
public class CustomerUserDeatilsServices implements UserDetailsService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		Optional<Customer> opt = customerRepository.findByEmail(username);
		
		if(opt.isPresent()) {
			
			Customer cus = opt.get();
			List<GrantedAuthority> authorities = new ArrayList<>();
		
		return new User(cus.getEmail(), cus.getPassword(), authorities);
		// return new CustomerUserDetails(cus);
		}
		
		else
		throw new UsernameNotFoundException("User Details not found");
	}

}
