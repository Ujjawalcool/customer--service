package com.customer.config;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.binding.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
}
