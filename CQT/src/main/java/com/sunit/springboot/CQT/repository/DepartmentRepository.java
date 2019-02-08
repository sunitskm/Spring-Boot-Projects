package com.sunit.springboot.CQT.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sunit.springboot.CQT.dto.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
