package com.nusacamp.app.controller.rest;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nusacamp.app.entity.User;
import com.nusacamp.app.entity.VUsersRegistered;
import com.nusacamp.app.jwt.JwtTokenProvider;
import com.nusacamp.app.service.UserService;
import com.nusacamp.app.service.ViewUsersService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "https://scm-covid19id-app.herokuapp.com/")
@RestController
@RequestMapping("/api/v1/v-users")
@Slf4j
@RequiredArgsConstructor
public class ViewUsersAPI {

	private final ViewUsersService viewUsersService;
	
	@GetMapping
	public ResponseEntity<List<VUsersRegistered>> getAllUsers(){
		return ResponseEntity.ok(this.viewUsersService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<VUsersRegistered> getUserById(@PathVariable int id) {
		Optional<VUsersRegistered> user = this.viewUsersService.findById(id);
		if (!user.isPresent()) {
			log.error("Id " + id + " is not existed");
			ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.ok(user.get());
	}
	
	
	
}
