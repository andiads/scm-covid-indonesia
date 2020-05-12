package com.nusacamp.app.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.nusacamp.app.entity.UserType;

@Repository
public interface UserTypeRepository extends JpaRepository<UserType, Integer> {
	
	@RestResource(path = "typeNameContains")
	public List<UserType> findByTypeNameContaining(@Param("type_name") String typeName); 
	
	public UserType findByTypeName(@Param("type_name") String typeName);
	
}
