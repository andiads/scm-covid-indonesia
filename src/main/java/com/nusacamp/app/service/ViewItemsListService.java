package com.nusacamp.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nusacamp.app.entity.VItemsList;
import com.nusacamp.app.repository.ItemsRepository;
import com.nusacamp.app.repository.ViewItemsListRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ViewItemsListService {
	
	private final ViewItemsListRepository viewItemsListRepository;
	
	public List<VItemsList> findAll() {
		return this.viewItemsListRepository.findAll();
	}
	
	public Optional<VItemsList> findById(int id) {
		return this.viewItemsListRepository.findById(id);
	}
	
	public VItemsList findByName(String name) {
		return this.viewItemsListRepository.findByName(name);
	}
	
	public VItemsList findByBrand(String brand) {
		return this.viewItemsListRepository.findByBrand(brand);
	}
	
	public VItemsList findByCategory(String category) {
		return this.viewItemsListRepository.findByCategory(category);
	}
	
	public VItemsList findBySubCategory(final String subCategory) {
		return this.viewItemsListRepository.findBySubCategory(subCategory);
	}
	
	public VItemsList findByDistributor(final String distributor) {
		return this.viewItemsListRepository.findByDistributor(distributor);
	}
	
	public VItemsList findByPackaging(final String packaging) {
		return this.viewItemsListRepository.findByPackaging(packaging);
	}
	
	public List<VItemsList> findAllAvailableitems() {
		return this.viewItemsListRepository.findAllAvailableItems();
	}
	
}
