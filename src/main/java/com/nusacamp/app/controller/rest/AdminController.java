package com.nusacamp.app.controller.rest;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nusacamp.app.entity.User;
import com.nusacamp.app.entity.UserType;
import com.nusacamp.app.entity.VUsersRegistered;
import com.nusacamp.app.service.UserService;
import com.nusacamp.app.service.UserTypeService;
import com.nusacamp.app.service.ViewUsersService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/admin")
@Slf4j
@RequiredArgsConstructor
public class AdminController {
	
	private final UserService userService;
	
	private final UserTypeService userTypeService;
	
	private final ViewUsersService viewUsersService;
	
	    // get user roles
		@GetMapping("/roles-all")
		public ResponseEntity<List<UserType>> getAllUserType() {
			return ResponseEntity.ok(this.userTypeService.findAll());
		}
		
		// > for admin to add user roles
		@PostMapping("/roles-add")
		public ResponseEntity<UserType> addUserType(@Valid @RequestBody UserType userType) {
			if (this.userTypeService.findByTypeName(userType.getTypeName())!=null) {
				return new ResponseEntity<>(HttpStatus.CONFLICT);
			}
			return ResponseEntity.ok(this.userTypeService.save(userType));
		}
		
		//get users from view v_users_registered table can't be manipulated
		@GetMapping("/v-users")
		public ResponseEntity<List<VUsersRegistered>> getAllVUsers(){
			return ResponseEntity.ok(this.viewUsersService.findAll());
		}

		//get user by id from view v_users_registered table can't be manipulated
		@GetMapping("/v-users/{id}")
		public ResponseEntity<VUsersRegistered> getVUserById(@PathVariable int id) {
			Optional<VUsersRegistered> user = this.viewUsersService.findById(id);
			if (!user.isPresent()) {
				log.error("Id " + id + " is not existed");
				ResponseEntity.badRequest().build();
			}
			
			return ResponseEntity.ok(user.get());
		}
		
		// get user from user table (not view)
		@GetMapping("/user-all")
		public ResponseEntity<List<User>> getAllUsers(){
			return ResponseEntity.ok(this.userService.findAll());
		}
		
		// add new user
		@PostMapping("/user-add")
		public ResponseEntity<User> addUser(@Valid @RequestBody User user, HttpServletRequest hsr) {
			if (this.userService.findUserByMail(user.getMail())!=null) {
				return new ResponseEntity<>(HttpStatus.CONFLICT);
			}
			user.setLastIp(hsr.getRemoteAddr());
			return ResponseEntity.ok(this.userService.saveUser(user));
		}
		
		// get user by id from user table (not view)
		@GetMapping("/user/{id}")
		public ResponseEntity<User> getUserById(@PathVariable int id) {
			Optional<User> user = this.userService.findById(id);
			if (!user.isPresent()) {
				log.error("Id " + id + " is not existed");
				ResponseEntity.badRequest().build();
			}
			
			return ResponseEntity.ok(user.get());
		}

		// update user
		@PutMapping("/user-update")
		public ResponseEntity<?> updateUser(@RequestBody User user, HttpServletRequest hsr) 
		{
			/*if (!this.userService.findById(id).isPresent()) {
				log.error("Id " + id + " is not existed");
				ResponseEntity.badRequest().build();
			}*/
			User existUser = userService.findUserByMail(user.getMail());
			if (existUser != null && !(existUser.getId()==user.getId())) {
				return new ResponseEntity<>(HttpStatus.CONFLICT);
			}
			user.setLastIp(hsr.getRemoteAddr());
			return new ResponseEntity<>(userService.updateUser(user), HttpStatus.CREATED);
		}

}
