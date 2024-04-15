package com.taskmanagement.User.Service.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taskmanagement.User.Service.model.User;



@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	

	User findByEmail(String email);



	

	boolean existsByEmail(String email);



	// Other custom query methods if needed
}