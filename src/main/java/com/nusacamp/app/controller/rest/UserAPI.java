package com.nusacamp.app.controller.rest;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
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
import com.nusacamp.app.exception.ResourceNotFoundException;
import com.nusacamp.app.jwt.JwtTokenProvider;
import com.nusacamp.app.repository.UserRepository;
import com.nusacamp.app.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

// local angular dev: http://localhost:4200
@CrossOrigin(origins = "https://scm-covid19id-webapp.herokuapp.com")
@RestController
@RequestMapping("/api/v1/users")
@Slf4j
@RequiredArgsConstructor
public class UserAPI {
	
	//private String PAGED_VIEW_URL = "http://localhost:8888/";
	
	@Autowired
	private JwtTokenProvider tokenProvider;
	
	private final UserService userService;
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers(){
		return ResponseEntity.ok(this.userService.findAll());
	}
	
	@PostMapping("/add")
	public ResponseEntity<User> add(@Valid @RequestBody User user, HttpServletRequest hsr) {
		if (this.userService.findUserByMail(user.getMail())!=null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		user.setLastIp(hsr.getRemoteAddr());
		return ResponseEntity.ok(this.userService.saveUser(user));
	}
	
	@GetMapping("/login")
	public ResponseEntity<?> getUser(Principal principal){
		// principal = httpServletRequest.getUserPrincipal
		if (principal == null) {
			//logout will also use here so we should return ok http status
			return ResponseEntity.ok(principal);
		}
		
		UsernamePasswordAuthenticationToken authToken =
				(UsernamePasswordAuthenticationToken) principal;
		User user = this.userService.findUserByMail(authToken.getName());
		user.setToken(tokenProvider.generateToken(authToken));
		
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id) {
		Optional<User> user = this.userService.findById(id);
		if (!user.isPresent()) {
			log.error("Id " + id + " is not existed");
			ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.ok(user.get());
	}

	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable int id,
			@Valid @RequestBody User user, HttpServletRequest hsr) 
	{
		if (!this.userService.findById(id).isPresent()) {
			log.error("Id " + id + " is not existed");
			ResponseEntity.badRequest().build();
		}
		user.setLastIp(hsr.getRemoteAddr());
		return ResponseEntity.ok(this.userService.updateUser(user));
	}

	/*@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable(value = "id") int id, 
			@Valid @RequestBody User userDetails) throws ResourceNotFoundException {
		
		User user = this.userService.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("User not found for this id :: "+ id));
		
		user.setFullname(userDetails.getFullname());
		user.setMail(userDetails.getMail());
		user.setStatus(userDetails.getStatus());
		
		final User updatedUser = userRepository.save(user);
		return ResponseEntity.ok(updatedUser);
	}
	*/
	
}
