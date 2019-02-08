package com.sunit.springboot.CQT.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunit.springboot.CQT.dto.Employee;
import com.sunit.springboot.CQT.repository.EmployeeRepository;
import com.sunit.springboot.CQT.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	public List<Employee> getEmployee(){
		return (List<Employee>) employeeRepository.findAll();
	}
	
	public Optional<Employee> findById(String id) {
		return employeeRepository.findById(id);
	}
	
	public Employee save(Employee employee) {
		Employee c = employeeRepository.save(employee);
		return c;
		
	}
	
	public void deleteById(String id) {
		employeeRepository.deleteById(id);
	}

}
