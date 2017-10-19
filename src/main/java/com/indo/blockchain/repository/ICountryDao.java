package com.indo.blockchain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.indo.blockchain.model.Country;

public interface ICountryDao extends JpaRepository<Country,Integer> {

}
