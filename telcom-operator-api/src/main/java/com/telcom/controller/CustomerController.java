package com.telcom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.telcom.service.CustomerService;

@RestController
@RequestMapping("/telco")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping(path = "/hello")
    public String getMessage() {
        return "Hello boot";
    }

    @GetMapping("/smsc")
    public ResponseEntity<Object> saveEmployee(@RequestParam String account_id,
    		@RequestParam String mobile,
    		@RequestParam String message) {
    	
    	return service.updateCustomer(account_id);
    }

    
}
