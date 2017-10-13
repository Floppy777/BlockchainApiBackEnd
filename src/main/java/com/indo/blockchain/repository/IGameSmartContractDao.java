package com.indo.blockchain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.indo.blockchain.model.GameSmartContract;

public interface IGameSmartContractDao extends JpaRepository<GameSmartContract, Integer>{

	@Query("SELECT g FROM GameSmartContract g INNER JOIN g.gameType t WHERE t.id=:id")
	public List<GameSmartContract> getGameSmartContractByType(@Param("id") Integer id);
}
