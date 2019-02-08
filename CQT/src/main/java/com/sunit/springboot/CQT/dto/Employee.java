package com.sunit.springboot.CQT.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Employee {
	@Id
	@Column(name = "emp_id")
	private String empId;
	@ManyToOne
	@JoinTable(name = "CQT_Rel_Emp_Dept", joinColumns = { @JoinColumn(name = "emp_id") }, inverseJoinColumns = {
			@JoinColumn(name = "dept_id") })
	private Department dept;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email_id")
	private String emailId;

	private String password;

	@Column(name = "is_valid")
	private Boolean active;

	@OneToMany(mappedBy = "employee",cascade=CascadeType.ALL)
	private List<Query> queries = new ArrayList<>();

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}
	@JsonIgnore
	public Department getDept() {
		return dept;
	}
	public Integer getDeptId() {
		if(this.dept==null) {
			return 0;
		}
		return this.dept.getDeptId();
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}
	
	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
	@JsonIgnore
	public List<Query> getQueries() {
		return queries;
	}

	public void setQueries(List<Query> queries) {
		this.queries = queries;
	}

	public Employee() {
		
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", dept=" + dept + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", emailId=" + emailId + ", password=" + password + ", active=" + active + ", queries=" + queries
				+ "]";
	}

	
}
