package com.customer.binding;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "userssssss")
public class User {
    public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
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
	
	@NotNull(message="nul fgjhklk hfgjhj")
	private String username;
    private String password;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="account_id")
    private String accountId;
}
