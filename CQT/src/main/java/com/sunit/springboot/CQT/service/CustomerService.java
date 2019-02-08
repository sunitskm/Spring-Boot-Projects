package com.sunit.springboot.CQT.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sunit.springboot.CQT.dto.Customer;
import com.sunit.springboot.CQT.repository.CustomerRepository;


@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	
	
	public List<Customer> getCustomer(){
		return (List<Customer>) customerRepository.findAll();
	}
	
	public Optional<Customer> findById(String id) {
		return customerRepository.findById(id);
	}
	
	public Customer save(Customer customer) {
		Customer c = customerRepository.save(customer);
		return c;
		
	}
	
	public void deleteById(String id) {
		customerRepository.deleteById(id);
	}
	
	
}
