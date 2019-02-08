package com.sunit.springboot.CQT.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunit.springboot.CQT.dto.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {

}
