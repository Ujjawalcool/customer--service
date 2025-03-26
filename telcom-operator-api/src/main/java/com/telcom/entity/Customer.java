package com.telcom.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="send_msg")
public class Customer {
 
	public String getAckId() {
		return ackId;
	}
	public void setAckId(String ackId) {
		this.ackId = ackId;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
    private String mobile;
    private String message;
    private String ackId;
    
    @Column(name ="account_id")
    private String accountId;
    private String status;
    private Timestamp received_ts;
    private Timestamp sent_ts;
    private String telco_response;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Timestamp getReceived_ts() {
		return received_ts;
	}
	public void setReceived_ts(Timestamp received_ts) {
		this.received_ts = received_ts;
	}
	public Timestamp getSent_ts() {
		return sent_ts;
	}
	public void setSent_ts(Timestamp sent_ts) {
		this.sent_ts = sent_ts;
	}
	public String getTelco_response() {
		return telco_response;
	}
	public void setTelco_response(String telco_response) {
		this.telco_response = telco_response;
	}
}
