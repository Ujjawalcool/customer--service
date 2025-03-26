package com.telcom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telcom.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
	
	List<Customer> findByAccountId(String account_id);
}
