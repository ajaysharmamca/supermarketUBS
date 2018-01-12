package com.ubs.supermarket.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ubs.supermarket.UbsSupermarketApplication;
import com.ubs.supermarket.entity.Item;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=UbsSupermarketApplication.class)
public class BasketTest {
	
	@Autowired
	ItemRepository repository;
	
	
	@Autowired
	Basket basket;

	@Test
	public void testAddItem() {
		Item itemB = repository.findById(2L);
		basket.addItem(itemB);
		basket.addItem(itemB);
		basket.addItem(itemB);
		basket.addItem(itemB);
		
		Item itemA = repository.findById(1L);
		
		basket.addItem(itemA);
		basket.addItem(itemA);
		
		
		Map<Item, AtomicInteger> items = basket.getItems();
		assertEquals(2, items.get(itemA).get());
		
		
		assertThat(4).isEqualTo( items.get(itemB).get());
	}
	
	
	@Test
	public void testDeleteItem() {
		Item itemB = repository.findById(2L);
		basket.addItem(itemB);
		basket.addItem(itemB);
		basket.addItem(itemB);
		basket.addItem(itemB);
		
		
		basket.deleteItem(itemB);
		basket.deleteItem(itemB);
		Map<Item, AtomicInteger> items = basket.getItems();
		
		assertThat(2).isEqualTo( items.get(itemB).get());
	}
	
	@Test
	public void testClear() {
		Item itemB = repository.findById(2L);
		basket.addItem(itemB);
		basket.addItem(itemB);
		basket.addItem(itemB);
		basket.addItem(itemB);
		
		
		basket.clear();
		Map<Item, AtomicInteger> items = basket.getItems();
		
		assertThat(0).isEqualTo( items.size());
	}
	
	@Test
	public void testGetItems() {
		Item itemB = repository.findById(2L);
		basket.addItem(itemB);
		basket.addItem(itemB);
		basket.addItem(itemB);

		Map<Item, AtomicInteger> items = basket.getItems();
		assertThat(3).isEqualTo( items.get(itemB).get());
	}
	
}
