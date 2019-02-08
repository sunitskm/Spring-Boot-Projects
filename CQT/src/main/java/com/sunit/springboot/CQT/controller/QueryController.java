package com.sunit.springboot.CQT.controller;

import java.time.LocalDateTime;
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

import com.sunit.springboot.CQT.dto.Customer;
import com.sunit.springboot.CQT.dto.Department;
import com.sunit.springboot.CQT.dto.Employee;
import com.sunit.springboot.CQT.dto.Query;
import com.sunit.springboot.CQT.repository.CustomerRepository;
import com.sunit.springboot.CQT.repository.DepartmentRepository;
import com.sunit.springboot.CQT.repository.QueryRepository;

@CrossOrigin(origins="http://localhost:4200",maxAge = 3600)
@RequestMapping("/query")
@RestController
public class QueryController {
	@Autowired
	private QueryRepository queryRepository;
	@Autowired
	private DepartmentRepository departmentRepository;
	@Autowired
	private CustomerRepository customerRepository;
	
	@GetMapping("/queries")
	public List<Query> getQuery(){
		return (List<Query>) queryRepository.findAll();
	}
	//Get all the unassigned queries based on a particular department 
	@GetMapping("/queries/dept/{id}")
	public List<Query> getQueryByDept(@PathVariable Integer id){
		List<Query> query =  (List<Query>) queryRepository.findAll();
		for(Query q:query) {
			if(q.getDepartment().getDeptId()!=id||!q.getStatus().equalsIgnoreCase("UNASSIGNED")) {
				query.remove(q);
			}
		}
		return query;
	}
	
	@GetMapping("/queries/customer/{id}")
	public List<Query> getQueryByCustomer(@PathVariable String id){
		
		List<Query> query =  customerRepository.getOne(id).getQueries();
		return query;
	}
	
	
	
	
	@GetMapping("/queries/{id}")
	public Optional<Query> findById(@PathVariable Integer id) {
		//Query emp = queryRepository.findById(id).orElse(null);
		//System.out.println(emp.getDept());
		return queryRepository.findById(id);
	}
	@PostMapping("/queries")
	public Query save(@RequestBody Query query) {
		Query q = queryRepository.save(query);
		return q;
		
	}
	@PostMapping("/queries/dept/{deptId}/cust/{custId}")
	public Query saveWithDept(@RequestBody Query query,@PathVariable Integer deptId,@PathVariable String custId) {
		Query q = new Query();
		q.setRating(query.getRating());
		q.setStatus(query.getStatus());
		System.out.println("Status = " + query.getStatus());
		Department d = departmentRepository.getOne(deptId);
		System.out.println("Hello");
		System.out.println(d.getDeptId()+" "+d.getDeptName());
		q.setDepartment(d);
		q.setDateCreated(LocalDateTime.now());
		Customer c = customerRepository.getOne(custId);
		System.out.println(c.getFirstName()+" "+c.getLastName());
		q.setCustomer(c);
		return queryRepository.save(q);
		
	}
	
	@PutMapping("/queries/{qId}/markresolved")
	public void markResolved(@PathVariable Integer qId) {
		Query query;
		query = queryRepository.getOne(qId);
		query.setStatus("Resolved");
		queryRepository.save(query);
	}
	
	@PutMapping("/queries/{qId}/rating/{rating}")
	public void setRating(@PathVariable Integer qId,@PathVariable Double rating) {
		Query query;
		System.out.println("The rating received is "+rating);
		query = queryRepository.getOne(qId);
		query.setRating(rating);
		queryRepository.save(query);
	}
	
	
	
	
	@DeleteMapping("/queries/{id}")
	public void deleteById(@PathVariable Integer id) {
		queryRepository.deleteById(id);
		
	}
}
