package com.sunit.springboot.CQT.dto;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class QueryDetails {
	@Id
	@GeneratedValue
	@Column(name="q_details_id")
	private Integer qDetailsId;
	@ManyToOne
	@JoinTable(
            name = "CQT_Rel_QueryDet_Query",
            joinColumns= {@JoinColumn(name="q_details_id")},
            inverseJoinColumns= {@JoinColumn(name="q_id")}
            )
	private Query query;
	private String subject;
	private String message;
	@Column(name="sender_id")
	private String senderId;
	@Column(name="received_date")
	
	private LocalDateTime receivedDate;
	public Integer getqDetailsId() {
		return qDetailsId;
	}
	public void setqDetailsId(Integer qDetailsId) {
		this.qDetailsId = qDetailsId;
	}
	@JsonIgnore
	public Query getQuery() {
		return query;
	}
	public Integer getQueryId() {
		return this.query.getqId();
	}
	public void setQuery(Query query) {
		this.query = query;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSenderId() {
		return senderId;
	}
	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}
	public LocalDateTime getReceivedDate() {
		return receivedDate;
	}
	public void setReceivedDate(LocalDateTime receivedDate) {
		this.receivedDate = receivedDate;
	}
	@Override
	public String toString() {
		return "QueryDetails [qDetailsId=" + qDetailsId + ", query=" + query + ", subject=" + subject + ", message="
				+ message + ", senderId=" + senderId + ", receivedDate=" + receivedDate + "]";
	}
	public QueryDetails() {
	}
	public QueryDetails(Query query, String subject, String message, String senderId, LocalDateTime receivedDate) {
		this.query = query;
		this.subject = subject;
		this.message = message;
		this.senderId = senderId;
		this.receivedDate = receivedDate;
	}
}
