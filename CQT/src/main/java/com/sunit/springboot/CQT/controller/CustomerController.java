package com.sunit.springboot.CQT.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunit.springboot.CQT.dto.Customer;
import com.sunit.springboot.CQT.repository.CustomerRepository;
import com.sunit.springboot.CQT.service.CustomerService;

@CrossOrigin(origins="http://localhost:4200",maxAge = 3600)
@RequestMapping("/customer")
@RestController
public class CustomerController {
	@Autowired
	private CustomerService customerRepository;
	
	@GetMapping("/customers")
	public List<Customer> getCustomer(){
		return customerRepository.getCustomer();
	}
	@GetMapping("/customers/{id}")
	public Optional<Customer> findById(@PathVariable String id) {
		return customerRepository.findById(id);
	}
	@PostMapping("/customers")
	public Customer save(@RequestBody Customer customer) {
		Customer c = customerRepository.save(customer);
		return c;
		
	}
	@DeleteMapping("/customers/{id}")
	public void deleteById(@PathVariable String id) {
		customerRepository.deleteById(id);
	}
}
