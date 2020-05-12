package com.nusacamp.app.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.nusacamp.app.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	@RestResource(path = "fullnameContains")
	public Page<User> findByFullnameContaining(@Param("fullname") String fullname, Pageable p);

	public User findByMail(@Param("mail") String mail);

}
