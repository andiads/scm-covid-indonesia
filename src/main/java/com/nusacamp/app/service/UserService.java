package com.nusacamp.app.service;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nusacamp.app.entity.User;
import com.nusacamp.app.entity.UserType;
import com.nusacamp.app.repository.UserRepository;
import com.nusacamp.app.repository.UserTypeRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
	private final UserRepository userRepository;
	private final UserTypeRepository userTypeRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	public List<User> findAll(){
		return this.userRepository.findAll();
	}
	
	public Optional<User> findById(Integer id) {
		return this.userRepository.findById(id);
	}
	
	
	public Page<User> findUserByFullnameContaining(String fullname, Pageable p){
		return this.userRepository.findByFullnameContaining(fullname, p);
	}
	
	public User findUserByMail(String mail) {
		return this.userRepository.findByMail(mail);
	}
	
	public User saveUser(final User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setStatus(1);
        //UserType userType = userTypeRepository.findByTypeName("ADMIN");
        //user.setUserTypes(new HashSet<UserType>(Arrays.asList(userType)));
        Timestamp ts = new Timestamp(new java.util.Date().getTime());
		user.setCreatedAt(ts.toString());
		user.setUpdatedAt(ts.toString());
		user.setLastLogin(ts.toString());
        return userRepository.save(user);
	}
	
	public User updateUser(final User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setStatus(1);
		Timestamp ts = new Timestamp(new java.util.Date().getTime());
		user.setUpdatedAt(ts.toString());
		return userRepository.save(user);
	}
	
	public User updateLastLogin(final User user) {
		Timestamp ts = new Timestamp(new java.util.Date().getTime());
		user.setLastLogin(ts.toString());
		return userRepository.save(user);
	}
	
	public Long numberOfUsers() {
		return this.userRepository.count();
	}
}
