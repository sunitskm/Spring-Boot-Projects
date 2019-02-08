package com.sunit.springboot.CQT.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonIgnore;
//
@Entity
public class Query {
	@Id
	@GeneratedValue
	@Column(name="q_id")
	private Integer qId;
	@ManyToOne
	@JoinTable(
            name = "CQT_Rel_Query_Cust",
            joinColumns= {@JoinColumn(name="q_id")},
            inverseJoinColumns= {@JoinColumn(name="c_id")}
            )
	private Customer customer;
	@ManyToOne
	@JoinTable(
            name = "CQT_Rel_Query_Emp",
            joinColumns= {@JoinColumn(name="q_id")},
            inverseJoinColumns= {@JoinColumn(name="emp_id")}
            )
	private Employee employee;
	@ManyToOne
	@JoinTable(
            name = "CQT_Rel_Query_Dept",
            joinColumns= {@JoinColumn(name="q_id")},
            inverseJoinColumns= {@JoinColumn(name="dept_id")}
            )
	private Department department;
	@Column(name="date_created")
	private LocalDateTime dateCreated;
	private String status;
	private double rating;
	@OneToMany(mappedBy="query", cascade=CascadeType.ALL )
	private List<QueryDetails> qd=new ArrayList<>();
	public Integer getqId() {
		return qId;
	}
	public void setqId(Integer qId) {
		this.qId = qId;
	}
	@JsonIgnore
	public Customer getCustomer() {
		return customer;
	}
	
	public String getCustomerName() {
		if(customer==null) {
			return "";
		}
		return this.customer.getFirstName()+" "+this.customer.getLastName();
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@JsonIgnore
	public Employee getEmployee() {
		return employee;
	}
	public String getEmployeeName() {
		if(employee==null) {
			return "";
		}
		return this.employee.getFirstName()+" "+this.employee.getLastName();
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	@JsonIgnore
	public Department getDepartment() {
		return department;
	}
	public String getDepartmentName() {
		if(department==null) {
			return "";
		}
		
		return this.department.getDeptName();
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public LocalDateTime getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public List<QueryDetails> getQd() {
		return qd;
	}
	public void setQd(List<QueryDetails> qd) {
		this.qd = qd;
	}
	
	@Override
	public String toString() {
		return "Query [qId=" + qId + ",dateCreated=" + dateCreated + ", status=" + status + ", rating=" + rating + ", qd=" + qd + "]";
	}
	public Query(Customer customer, Employee employee, Department department, LocalDateTime dateCreated, String status,
			double rating, List<QueryDetails> qd) {
		this.customer = customer;
		this.employee = employee;
		this.department = department;
		this.dateCreated = dateCreated;
		this.status = status;
		this.rating = rating;
		this.qd = qd;
	}
	public Query() {
	}
	
	
}
