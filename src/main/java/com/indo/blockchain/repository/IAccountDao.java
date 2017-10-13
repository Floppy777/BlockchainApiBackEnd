package com.indo.blockchain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.indo.blockchain.model.Account;

@Repository
public interface IAccountDao extends JpaRepository<Account, Integer>,IAccountRepositoryCustom{
	
	
}
