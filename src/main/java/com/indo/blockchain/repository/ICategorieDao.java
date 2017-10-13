package com.indo.blockchain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.indo.blockchain.model.Categorie;

@Repository
public interface ICategorieDao extends JpaRepository<Categorie,Integer> {
}
