package com.telcom.service;

import org.springframework.http.ResponseEntity;

import com.telcom.entity.Customer;

public interface CustomerService {

    
	ResponseEntity<Object> updateCustomer(String accountId);
  
}
