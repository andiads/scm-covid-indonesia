package com.nusacamp.app.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import com.nusacamp.app.entity.Items;
import com.nusacamp.app.entity.VItemsList;

public interface ViewItemsListRepository extends JpaRepository<VItemsList, Integer> {
	
	@RestResource(path = "nameContains")
	public Page<VItemsList> findByNameContaining(@Param("name") String name, Pageable p);
	
	public VItemsList findByName(@Param("name") String name);
	
	public VItemsList findByBrand(@Param("brand") String brand);
	
	public VItemsList findByDistributor(@Param("distributor") String distributor);
	
	public VItemsList findByCategory(@Param("category") String category);
	
	public VItemsList findBySubCategory(@Param("subCategory") String subCategory);
	
	public VItemsList findByPackaging(@Param("packaging") String packaging);
	
	@Query(
		value="SELECT * FROM v_items_list v WHERE v.shown = 1",
		nativeQuery = true)
	public List<VItemsList> findAllAvailableItems();

}
