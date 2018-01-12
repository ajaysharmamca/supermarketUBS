package com.ubs.supermarket.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ubs.supermarket.entity.Item;


public interface ItemRepository extends JpaRepository<Item, Long> {
	
	 Item findByName(String name);
	 Item findById(Long id);

}
