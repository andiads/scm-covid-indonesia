package com.nusacamp.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nusacamp.app.entity.VUsersRegistered;
import com.nusacamp.app.repository.UserRepository;
import com.nusacamp.app.repository.UserTypeRepository;
import com.nusacamp.app.repository.ViewUsersRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ViewUsersService {

	private final ViewUsersRepository viewUsersRepository;
	
	public List<VUsersRegistered> findAll(){
		return this.viewUsersRepository.findAll();
	}
	
	public Optional<VUsersRegistered> findById(Integer id) {
		return this.viewUsersRepository.findById(id);
	}
	
	
	public Page<VUsersRegistered> findUserByFullnameContaining(String fullname, Pageable p){
		return this.viewUsersRepository.findByFullnameContaining(fullname, p);
	}
	
	public VUsersRegistered findUserByMail(String mail) {
		return this.viewUsersRepository.findByMail(mail);
	}
	
}
