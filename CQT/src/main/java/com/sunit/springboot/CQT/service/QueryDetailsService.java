package com.sunit.springboot.CQT.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.sunit.springboot.CQT.dto.QueryDetails;
import com.sunit.springboot.CQT.repository.QueryDetailsRepository;

public class QueryDetailsService {
	@Autowired
	private QueryDetailsRepository queryDetailsRepository;
	
	
	public List<QueryDetails> getQueryDetails(){
		return (List<QueryDetails>) queryDetailsRepository.findAll();
	}
	
	public Optional<QueryDetails> findById(Integer id) {
		return queryDetailsRepository.findById(id);
	}
	
	public QueryDetails save(QueryDetails query) {
		QueryDetails c = queryDetailsRepository.save(query);
		return c;
		
	}
	
	public void deleteById(Integer id) {
		queryDetailsRepository.deleteById(id);
	}
}

