package com.sunit.springboot.CQT.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer {
	
	@Id
	@Column(name="c_id")
	private String cId;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	
	private String password;
	@Column(name="email_id")
	private String emailId;
	@Column(name="is_valid")
	private boolean active;
	@OneToMany(mappedBy="customer", cascade=CascadeType.ALL)
	private List<Query> queries=new ArrayList<Query>();
	public Customer() {
	}
	public String getcId() {
		return cId;
	}
	public void setcId(String cId) {
		this.cId = cId;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public List<Query> getQueries() {
		return queries;
	}
	public void setQueries(List<Query> queries) {
		this.queries = queries;
	}
	@Override
	public String toString() {
		return "Customer [cId=" + cId + ", firstName=" + firstName + ", lastName=" + lastName + ", password=" + password
				+ ", emailId=" + emailId + ", isValid=" + active + ", queries=" + queries + "]";
	}
	public Customer(String cId, String firstName, String lastName, String password, String emailId, boolean active,
			List<Query> queries) {
		this.cId = cId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.emailId = emailId;
		this.active = active;
		this.queries = queries;
	}
	
	
	
	
}
