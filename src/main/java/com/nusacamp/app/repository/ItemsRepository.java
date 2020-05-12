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
	public List<Items> findByItemNameContaining(@Param("item_name") String itemName);
	
	@RestResource(path = "itemCodeContains")
	public List<Items> findByItemCodeContaining(@Param("item_code") String itemCode);
	
	@RestResource(path = "itemBrandContains")
	public List<Items> findByItemBrandContaining(@Param("item_brand") String itemBrand);
	
	
}
