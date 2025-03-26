package com.customer.binding;

import jakarta.validation.constraints.NotNull;

public class Customer {
    public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
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
	public void setPassword(String password) {
		this.password = password;
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
	private String username;
    private String password;
    
    private String mobile;
    private String message;
    private String ackId;
    
    private String accountId;
}
