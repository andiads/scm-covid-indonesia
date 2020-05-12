package com.nusacamp.app.service;

import com.nusacamp.app.repository.UserTypeRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nusacamp.app.entity.UserType;


@Service
@Transactional
@RequiredArgsConstructor
public class UserTypeService {
	private final UserTypeRepository userTypeRepository;
	
	public List<UserType> findAll(){
		return this.userTypeRepository.findAll();
	}
	
	public Optional<UserType> findById(int id) {
		return this.userTypeRepository.findById(id);
	}
	
	public UserType findByTypeName(String typeName) {
		return this.userTypeRepository.findByTypeName(typeName);
	}
	
	public List<UserType> findByTypeNameContaining(String typeName) {
		return this.userTypeRepository.findByTypeNameContaining(typeName);
	}
	
	public UserType save(UserType userType) {
		return this.userTypeRepository.save(userType);
	}

}
