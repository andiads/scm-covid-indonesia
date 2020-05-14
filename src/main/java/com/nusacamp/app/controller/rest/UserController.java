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
import com.nusacamp.app.entity.UserType;
import com.nusacamp.app.entity.VUsersRegistered;
import com.nusacamp.app.entity.Items;
import com.nusacamp.app.entity.VItemsList;
import com.nusacamp.app.exception.ResourceNotFoundException;
import com.nusacamp.app.jwt.JwtTokenProvider;
import com.nusacamp.app.repository.UserRepository;
import com.nusacamp.app.service.ItemsService;
import com.nusacamp.app.service.UserService;
import com.nusacamp.app.service.UserTypeService;
import com.nusacamp.app.service.ViewItemsListService;
import com.nusacamp.app.service.ViewUsersService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

// local angular dev: http://localhost:4200
@RestController
@RequestMapping("/api/v1/users")
@Slf4j
@RequiredArgsConstructor
public class UserController {
	
	@Autowired
	private JwtTokenProvider tokenProvider;
	
	private final UserService userService;
	
	private final UserTypeService userTypeService;
	
	private final ItemsService itemsService;
	
	private final ViewUsersService viewUsersService;
	
	private final ViewItemsListService viewItemsListService;
	
	
	
	/********************************
	 * 								*
	 * 			USERS CRUD			*
	 * 								*
	 ********************************/
	// get user roles
	@GetMapping("/roles")
	public ResponseEntity<List<UserType>> getAllUserType() {
		return ResponseEntity.ok(this.userTypeService.findAll());
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
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers(){
		return ResponseEntity.ok(this.userService.findAll());
	}
	
	@PostMapping("/add")
	public ResponseEntity<User> addUser(@Valid @RequestBody User user, HttpServletRequest hsr) {
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
	
	
	// get user by id from user table (not view)
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id) {
		Optional<User> user = this.userService.findById(id);
		if (!user.isPresent()) {
			log.error("Id " + id + " is not existed");
			ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.ok(user.get());
	}

	// update user data
	@PutMapping("/update/{id}")
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

	/********************************
	 * 								*
	 * 			ITEMS CRUD			*
	 * 								*
	 ********************************/
	
	// get items from view v_items_list
	@GetMapping("/v-items")
	public ResponseEntity<List<VItemsList>> getAllVItems(){
		return ResponseEntity.ok(this.viewItemsListService.findAll());
	}

	// get item by id from view v_items_list
	@GetMapping("/v-items/{id}")
	public ResponseEntity<VItemsList> getVItemById(@PathVariable int id) {
		Optional<VItemsList> item = this.viewItemsListService.findById(id);
		if (!item.isPresent()) {
			log.error("Id " + id + " is not existed");
			ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.ok(item.get());
	}
	
	// get avail item by shown=1 only from view v_items_list
	@GetMapping("/v-items/available")
	public ResponseEntity<List<VItemsList>> getAvailableItemsList() {
		return ResponseEntity.ok(this.viewItemsListService.findAllAvailableitems());
	}
	
	// add new item
	@PostMapping("/items/add")
	public ResponseEntity<Items> addItem(@Valid @RequestBody Items item) {
		if (this.itemsService.findByItemCode(item.getItemCode())!=null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return ResponseEntity.ok(this.itemsService.save(item));
	}
	
	// get Item by id from Items table (not view)
	@GetMapping("/items/{id}")
	public ResponseEntity<Items> getItemById(@PathVariable int id) {
		Optional<Items> item = this.itemsService.findById(id);
		if (!item.isPresent()) {
			log.error("Id " + id + " is not existed");
			ResponseEntity.badRequest().build();
		}
			
		return ResponseEntity.ok(item.get());
	}
	
	// update item data
	@PutMapping("/items/update/{id}")
	public ResponseEntity<Items> updateItem(@PathVariable int id,
			@Valid @RequestBody Items item) 
	{
		if (!this.itemsService.findById(id).isPresent()) {
			log.error("Id " + id + " is not existed");
			ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.ok(this.itemsService.update(item));
	}
	
	// delete item data (set shown from 1 to 0)
	@PutMapping("/items/delete/{id}")
	public ResponseEntity<Items> deleteItem(@PathVariable int id,
			@Valid @RequestBody Items item) 
	{
		if (!this.itemsService.findById(id).isPresent()) {
			log.error("Id " + id + " is not existed");
			ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.ok(this.itemsService.delete(item));
	}
	
}
