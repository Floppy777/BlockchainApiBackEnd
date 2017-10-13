package com.indo.blockchain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.indo.blockchain.model.Role;

@Repository
public interface IRoleDao extends JpaRepository<Role, Integer>{
	
	@Query("Select r from Role r where r.libelle=:role")
	Role findByRole(@Param("role")String role);

}
