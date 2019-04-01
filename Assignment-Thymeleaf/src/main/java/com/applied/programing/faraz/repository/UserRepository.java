package com.applied.programing.faraz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.applied.programing.faraz.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public User findByLoginIdAndPassword(String loginId,String password); 
	
	
}
