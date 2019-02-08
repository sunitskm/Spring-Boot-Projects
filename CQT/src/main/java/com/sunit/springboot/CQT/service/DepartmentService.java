package com.sunit.springboot.CQT.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunit.springboot.CQT.dto.Department;
import com.sunit.springboot.CQT.repository.DepartmentRepository;

@Service
public class DepartmentService {
	@Autowired
	private DepartmentRepository departmentRepository;
	
	
	public List<Department> getDepartment(){
		return (List<Department>) departmentRepository.findAll();
	}
	
	public Optional<Department> findById(Integer id) {
		return departmentRepository.findById(id);
	}
	
	public Department save(Department department) {
		Department c = departmentRepository.save(department);
		return c;
		
	}
	
	public void deleteById(Integer id) {
		departmentRepository.deleteById(id);
	}
}
