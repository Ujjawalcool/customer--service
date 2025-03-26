package com.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customer.binding.User;

@Repository
public interface UserRepo extends JpaRepository<User, String> {
	
	 User findByUsernameAndPassword(String username,String password);

}
