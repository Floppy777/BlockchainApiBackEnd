package com.indo.blockchain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.indo.blockchain.model.GameType;

@Repository
public interface IGameTypeDao extends JpaRepository<GameType, Integer> {

}
