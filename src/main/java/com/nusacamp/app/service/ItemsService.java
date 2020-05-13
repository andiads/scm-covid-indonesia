package com.nusacamp.app.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nusacamp.app.entity.Items;
import com.nusacamp.app.repository.ItemsRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemsService {
	
	private final ItemsRepository itemsRepository;
	
	public List<Items> findAll() {
		return this.itemsRepository.findAll();
	}
	
	public Optional<Items> findById(int id) {
		return this.itemsRepository.findById(id);
	}
	
	public List<Items> findByItemName(String itemName) {
		return this.itemsRepository.findByItemNameContaining(itemName);
	}
	
	public List<Items> findByItemCode(String itemCode) {
		return this.itemsRepository.findByItemCodeContaining(itemCode);
	}
	
	public List<Items> findByItemBrand(String itemBrand) {
		return this.itemsRepository.findByItemBrandContaining(itemBrand);
	}
	
	public Items save(final Items items) {
		Timestamp ts = new Timestamp(new java.util.Date().getTime());
		items.setShown(1);
		items.setCreatedAt(ts.toString());
		items.setUpdatedAt(ts.toString());
		items.setCreatedBy(7);// currently set to 7 as a admin, since there's no login yet
		return this.itemsRepository.save(items);
	}
	
	public Items update(final Items items) {
		Timestamp ts = new Timestamp(new java.util.Date().getTime());
		items.setShown(1);
		items.setUpdatedAt(ts.toString());
		return this.itemsRepository.save(items);
	}
	
	// delete is actually update the shown from 1 to 0
	public Items delete(final Items items) {
		Timestamp ts = new Timestamp(new java.util.Date().getTime());
		items.setShown(0);
		items.setUpdatedAt(ts.toString());
		return this.itemsRepository.save(items);
	}
	
	public Long numberOfItems() {
		return this.itemsRepository.count();
	}
	
}
