package com.indo.blockchain.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.indo.blockchain.model.Account;

@Repository
public interface IAccountRepositoryCustom {
	
	@Query("Select a from Account a where a.username=:username")
	public Account findByUsername(@Param("username")String username);
}
