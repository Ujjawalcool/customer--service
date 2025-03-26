package com.scheduler.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scheduler.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
	
	List<Customer> findByStatus(String status);
}
