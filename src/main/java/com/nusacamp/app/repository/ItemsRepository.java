package com.nusacamp.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.nusacamp.app.entity.Items;

@Repository
public interface ItemsRepository extends JpaRepository<Items, Integer> {
	
	@RestResource(path = "itemNameContains")
	public List<Items> findByNameContaining(@Param("name") String name);
	
	@RestResource(path = "itemCodeContains")
	public List<Items> findByCodeContaining(@Param("code") String code);
	
	@RestResource(path = "itemBrandContains")
	public List<Items> findByBrandContaining(@Param("brand") String brand);
	
	
}
