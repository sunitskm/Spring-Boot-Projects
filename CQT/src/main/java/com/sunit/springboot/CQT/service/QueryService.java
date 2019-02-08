package com.sunit.springboot.CQT.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunit.springboot.CQT.dto.Query;
import com.sunit.springboot.CQT.repository.QueryRepository;

@Service
public class QueryService {
	@Autowired
	private QueryRepository queryRepository;
	
	
	public List<Query> getQuery(){
		return (List<Query>) queryRepository.findAll();
	}
	
	public Optional<Query> findById(Integer id) {
		return queryRepository.findById(id);
	}
	
	public Query save(Query query) {
		Query c = queryRepository.save(query);
		return c;
		
	}
	
	public void deleteById(Integer id) {
		queryRepository.deleteById(id);
	}
}

