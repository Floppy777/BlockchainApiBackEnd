package com.indo.blockchain.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.indo.blockchain.model.Categorie;
import com.indo.blockchain.model.Project;
import com.indo.blockchain.model.User;

@Repository
public interface IProjectDao extends JpaRepository<Project, Integer> {

	/*
	 * select application FROM Application a join a.customer c join c.users u
	 * where u.id = :userId
	 */

	@Query(value = "SELECT * FROM project WHERE project.user = :user", nativeQuery = true)
	public List<Project> findByCreatedBy(@Param("user") User user);

	@Query("SELECT p FROM Project p WHERE p.categorie = :categorie")
	public List<Project> findByCategorie(@Param("categorie") Categorie categorie);

	@Query("SELECT p FROM Project p WHERE p.name LIKE :name")
	public List<Project> findByNameLike(String name);

	// || '%'
	@Query("Select p from Project p WHERE" +
			"(:name IS NULL or p.name LIKE '%'||:name||'%') AND "+ 
			"(:address IS NULL or p.address LIKE '%'||:address||'%') AND " +
			"(:categorie IS NULL or p.categorie = :categorie)")
	Page<Project> findByAll(@Param("name") String name, @Param("address") String address,@Param("categorie") Categorie categorie, Pageable page);

}
