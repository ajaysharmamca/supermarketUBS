package com.ubs.supermarket.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.ubs.supermarket.UbsSupermarketApplication;
import com.ubs.supermarket.entity.Item;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=UbsSupermarketApplication.class)
public class ItemRepositoryTest {
	
	@Autowired
	ItemRepository repository;

	@Test
	public void testFindById() {
		Item item = repository.findById(1L);
		assertEquals("A", item.getName());
	}
	
	@Test
	@DirtiesContext
	public void testDeleteById() {
		repository.delete(3L);
		assertNull(repository.findById(3L));
	}
	
	@Test
	@DirtiesContext
	public void testSave() {
		Item item = repository.findById(4L);
		item.setName("E - Updated");
		repository.save(item);
		Item item1 = repository.findById(4L);
		assertEquals("E - Updated", item1.getName());;
	}
	
	
}
