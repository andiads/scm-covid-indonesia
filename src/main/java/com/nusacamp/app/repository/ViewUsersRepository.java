package com.nusacamp.app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import com.nusacamp.app.entity.User;
import com.nusacamp.app.entity.VUsersRegistered;

public interface ViewUsersRepository extends JpaRepository<VUsersRegistered, Integer> {
	@RestResource(path = "fullnameContains")
	public Page<VUsersRegistered> findByFullnameContaining(@Param("fullname") String fullname, Pageable p);

	public VUsersRegistered findByMail(@Param("mail") String mail);

}
