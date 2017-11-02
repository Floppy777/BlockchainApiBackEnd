package com.indo.blockchain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.indo.blockchain.model.Status;

@Repository
public interface IStatusDao extends JpaRepository<Status, Integer> {

}
