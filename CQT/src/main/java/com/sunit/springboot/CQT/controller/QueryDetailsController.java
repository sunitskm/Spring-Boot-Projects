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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunit.springboot.CQT.dto.Query;
import com.sunit.springboot.CQT.dto.QueryDetails;
import com.sunit.springboot.CQT.repository.CustomerRepository;
import com.sunit.springboot.CQT.repository.DepartmentRepository;
import com.sunit.springboot.CQT.repository.QueryDetailsRepository;
import com.sunit.springboot.CQT.repository.QueryRepository;

@CrossOrigin(origins="http://localhost:4200",maxAge = 3600)
@RequestMapping("/querydetail")
@RestController
public class QueryDetailsController {
	@Autowired
	private QueryDetailsRepository queryDetailsRepository;
	@Autowired
	private QueryRepository queryRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@GetMapping("/querydetails")
	public List<QueryDetails> getQueryDetails(){
		return (List<QueryDetails>) queryDetailsRepository.findAll();
	}
	@GetMapping("/querydetails/{id}")
	public Optional<QueryDetails> findById(@PathVariable Integer id) {
		//Employee emp = employeeRepository.findById(id).orElse(null);
		//System.out.println(emp.getDept());
		return queryDetailsRepository.findById(id);
	}
	
	@GetMapping("/querydetailsbyquery/{id}")
	public List<QueryDetails> findDetailsById(@PathVariable Integer id) {
		//Employee emp = employeeRepository.findById(id).orElse(null);
		//System.out.println(emp.getDept());
		Query query= queryRepository.getOne(id);
		return query.getQd();
	}
	
	@PostMapping("/querydetails/query/{qId}/sender/{sId}")
	public QueryDetails save(@RequestBody QueryDetails queryDetails,@PathVariable Integer qId,@PathVariable String sId) {
		System.out.println("I am inside query details function "+qId);
		Query q = queryRepository.getOne(qId);
		System.out.println("All good till here ");
		System.out.println("Query is "+q);
		queryDetails.setQuery(q);
		queryDetails.setReceivedDate(LocalDateTime.now());
		QueryDetails qd = queryDetailsRepository.save(queryDetails);
		System.out.println(qd);
		return qd;
		
	}
	
	
	@DeleteMapping("/querydetails/{id}")
	public void deleteById(@PathVariable Integer id) {
		queryDetailsRepository.deleteById(id);
	}
	
	@PostMapping("/querydetails/customer/{custID}/dept/{deptID}")
	public QueryDetails save(@RequestBody QueryDetails queryDetails,@PathVariable String custID,@PathVariable Integer deptID) {
		
		Query query = new Query();
		Query returnedQuery;
		{
			query.setDateCreated(LocalDateTime.now());
			query.setRating(0.0);
			query.setStatus("Unassigned");
			query.setCustomer(customerRepository.getOne(custID));
			query.setDepartment(departmentRepository.getOne(deptID));
		}
		
		returnedQuery = queryRepository.save(query);
		
		{
		queryDetails.setQuery(returnedQuery);
		queryDetails.setSenderId(custID);
		queryDetails.setReceivedDate(LocalDateTime.now());
		}
		queryDetailsRepository.save(queryDetails);
		
		return null;
	}
}
