package com.sunit.springboot.CQT.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunit.springboot.CQT.dto.Department;
import com.sunit.springboot.CQT.dto.Employee;
import com.sunit.springboot.CQT.repository.DepartmentRepository;
import com.sunit.springboot.CQT.repository.EmployeeRepository;

@CrossOrigin(origins="http://localhost:4200",maxAge = 3600)
@RequestMapping("/employee")
@RestController
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@GetMapping("/employees")
	public List<Employee> getEmployee(){
		return (List<Employee>) employeeRepository.findAll();
	}
	@GetMapping("/employees/{id}")
	public Optional<Employee> findById(@PathVariable String id) {
		return employeeRepository.findById(id);
	}
	@PostMapping("/employees")
	public Employee save(@RequestBody Employee employee) {
		
		return employeeRepository.save(employee);
		
	}
	
	@PostMapping("/employees/dept/{deptId}")
	public Employee saveWithDept(@RequestBody Employee employee,@PathVariable Integer deptId) {
		Department d = departmentRepository.getOne(deptId);
		System.out.println("Hello");
		System.out.println(d.getDeptId()+" "+d.getDeptName());
		employee.setDept(d);
		
		return employeeRepository.save(employee);
		//return null;
	}
	
	@PutMapping("/employees")
	public Employee update(@RequestBody Employee employee) {
		
		  Employee olde = new Employee(); 
		  olde = employeeRepository.getOne(employee.getEmpId());
		  
		  employee.setDept(olde.getDept()); System.out.println(employee);
		  System.out.println("old Dept "+olde.getDept());
		  employee.setQueries(olde.getQueries());
		  System.out.println("Old Queries "+olde.getQueries());
		  return employeeRepository.save(employee);
	}
	@DeleteMapping("/employees/{id}")
	public void deleteById(@PathVariable String id) {
		employeeRepository.deleteById(id);
	}
}
