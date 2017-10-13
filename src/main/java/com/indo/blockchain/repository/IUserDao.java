package com.indo.blockchain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.indo.blockchain.model.User;

@Repository
public interface IUserDao extends JpaRepository<User, Integer>{
	
	@Query("Select u from User u where u.mail=:username")
	public User findByUsername(@Param("username")String username);
	
}
