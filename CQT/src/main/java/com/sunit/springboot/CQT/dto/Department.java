package com.sunit.springboot.CQT.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "department")
public class Department {
	@Id
	@GeneratedValue
	@Column(name = "dept_id")
	private Integer deptId;

	@Column(name = "dept_name")
	private String deptName;

	@OneToMany(mappedBy = "dept",cascade=CascadeType.ALL)
	private List<Employee> employee = new ArrayList<>();

	@OneToMany(mappedBy = "department", cascade=CascadeType.ALL)
	private List<Query> query = new ArrayList<>();

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	//@JsonIgnore
	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}

	//@JsonIgnore
	public List<Query> getQuery() {
		return query;
	}

	public void setQuery(List<Query> query) {
		this.query = query;
	}

	/*
	 * 
	 * 
	 * public Department( String deptName, List<Employee> employee) {
	 * 
	 * this.deptName = deptName; this.employee = employee;
	 * System.out.println("Constructor of Department has been called"); } public
	 * Department() { } public Integer getDeptId() { return deptId; } public void
	 * setDeptId(Integer deptId) { this.deptId = deptId; } public String
	 * getDeptName() { return deptName; } public void setDeptName(String deptName) {
	 * this.deptName = deptName; } public List<Employee> getEmployee() { return
	 * employee; } public void setEmployee(List<Employee> employee) { this.employee
	 * = employee; }
	 * 
	 * @Override public String toString() { return "Department [deptId=" + deptId +
	 * ", deptName=" + deptName + ", employee=" + employee + "]"; }
	 */
}
