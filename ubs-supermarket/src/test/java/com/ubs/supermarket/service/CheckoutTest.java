package com.ubs.supermarket.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ubs.supermarket.UbsSupermarketApplication;
import com.ubs.supermarket.entity.Item;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=UbsSupermarketApplication.class)
public class CheckoutTest {
	
	@Autowired
	private ItemRepository repository;
	
	@Autowired
	private Basket basket;
	
	@Autowired
	private Checkout checkout;
	
	
	@Test
	public void testGetTotalPrice2A5B() {
		basket.clear();
		Double  totalPrice = new Double(0);
		Item itemB = repository.findById(2L);
		basket.addItem(itemB);
		basket.addItem(itemB);
		basket.addItem(itemB);
		basket.addItem(itemB);
		basket.addItem(itemB);
	
		Item itemA = repository.findById(1L);
		
		basket.addItem(itemA);
		basket.addItem(itemA);
		
		
		totalPrice = checkout.getTotalPrice();
		
		assertEquals(new Double(120), totalPrice);
		
	}
	
	@Test
	public void testGetTotalPrice389A() {
		basket.clear();
		Double  totalPrice = new Double(0);
		Item itemA = repository.findById(1L);
		for (int i=0; i < 389; i ++) {
			basket.addItem(itemA);
						
		}
		
		totalPrice = checkout.getTotalPrice();
		
		assertEquals(new Double(3025), totalPrice);
		
	}


}
