package com.indo.blockchain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.indo.blockchain.model.EthereumAccount;

@Repository
public interface IEthereumAccountRepository extends JpaRepository<EthereumAccount, Integer> {

}
