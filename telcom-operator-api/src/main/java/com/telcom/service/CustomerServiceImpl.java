package com.telcom.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.telcom.entity.Customer;
import com.telcom.entity.RespBody;
import com.telcom.repository.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepo repo;

	@Override
	public ResponseEntity<Object> updateCustomer(String accountId) {
		List<Customer> list1=repo.findAll();
		List<Customer> list=repo.findByAccountId(accountId);
		for(Customer cust:list) {
			cust.setStatus("SENT");
			cust.setSent_ts(new Timestamp(System.currentTimeMillis()));
			repo.save(cust);
		}
		RespBody res=new RespBody("SUCCESS");
		return new ResponseEntity<>(res,HttpStatus.ACCEPTED);
		
	}
}
