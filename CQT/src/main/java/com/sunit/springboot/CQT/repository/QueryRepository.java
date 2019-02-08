package com.sunit.springboot.CQT.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunit.springboot.CQT.dto.Query;

public interface QueryRepository extends JpaRepository<Query, Integer> {

}
