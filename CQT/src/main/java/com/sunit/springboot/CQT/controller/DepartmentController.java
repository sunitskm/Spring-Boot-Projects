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

import com.sunit.springboot.CQT.dto.Department;
import com.sunit.springboot.CQT.repository.DepartmentRepository;

@CrossOrigin(origins="http://localhost:4200",maxAge = 3600)
@RequestMapping("/department")
@RestController
public class DepartmentController {
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@GetMapping("/departments")
	public List<Department> getDepartment(){
		return (List<Department>) departmentRepository.findAll();
	}
	@GetMapping("/departments/{id}")
	public Optional<Department> findById(@PathVariable Integer id) {
		return departmentRepository.findById(id);
	}
	@PostMapping("/departments")
	public Department save(@RequestBody Department department) {
		Department d = departmentRepository.save(department);
		return d;
		
	}
	@DeleteMapping("/departments/{id}")
	public void deleteById(@PathVariable Integer id) {
		departmentRepository.deleteById(id);
	}
}
