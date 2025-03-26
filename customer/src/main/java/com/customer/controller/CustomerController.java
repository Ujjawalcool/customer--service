package com.customer.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.customer.binding.Customer;
import com.customer.binding.User;
import com.customer.exception.NoCustomerFoundException;
import com.customer.repository.UserRepo;
import com.customer.service.CustomerService;

import jakarta.validation.ConstraintViolationException;

@RestController
public class CustomerController {

	ConstraintViolationException ex;
    @Autowired
    private CustomerService service;
    
    @Autowired
    private UserRepo repo;
    
    @GetMapping("/telco/sendmsg")
    public ResponseEntity<Object> createOrder(@RequestParam String username,
    		@RequestParam String password,
    		@RequestParam String mobile,
    		@RequestParam String message) {
    	User user=repo.findByUsernameAndPassword(username, password);
    	if(null==user)
    		throw new NoCustomerFoundException("No user found");
    	Customer cust=new Customer();
    	cust.setMessage(message);
    	cust.setMobile(mobile);
    	
    	UUID uuid=UUID.randomUUID();
    	cust.setAckId(uuid.toString());
    	
    	cust.setAccountId(user.getAccountId());
        return service.addMsg(cust);
        
    }
}
