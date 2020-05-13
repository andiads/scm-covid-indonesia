package com.nusacamp.app.controller.rest;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nusacamp.app.entity.User;
import com.nusacamp.app.entity.UserType;
import com.nusacamp.app.exception.ResourceNotFoundException;
import com.nusacamp.app.jwt.JwtTokenProvider;
import com.nusacamp.app.repository.UserTypeRepository;
import com.nusacamp.app.service.UserService;
import com.nusacamp.app.service.UserTypeService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "https://scm-covid19id-webapp.herokuapp.com")
@RestController
@RequestMapping("/api/v1/roles")
@Slf4j
@RequiredArgsConstructor
public class UserTypeAPI {

	@Autowired
	private JwtTokenProvider tokenProvider;
	
	private final UserTypeService userTypeService;
	
	@GetMapping
	public ResponseEntity<List<UserType>> getAllUserType() {
		return ResponseEntity.ok(this.userTypeService.findAll());
	}
	
	@PostMapping("/add")
	public ResponseEntity<UserType> add(@Valid @RequestBody UserType userType) {
		if (this.userTypeService.findByTypeName(userType.getTypeName())!=null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return ResponseEntity.ok(this.userTypeService.save(userType));
	}
}
