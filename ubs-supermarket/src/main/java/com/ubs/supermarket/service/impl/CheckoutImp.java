package com.ubs.supermarket.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ubs.supermarket.entity.Item;
import com.ubs.supermarket.entity.SpecialPrice;
import com.ubs.supermarket.service.Basket;
import com.ubs.supermarket.service.Checkout;

@Component
public class CheckoutImp implements Checkout {
	
	@Autowired
	private Basket basket;
	
	@Override
	public Double getTotalPrice() {
		Map<Item, AtomicInteger> basketItems = basket.getItems();
	
		Double result = new Double(0);
		int itemPendingQuantity = 0;
		Item basketItem = null;
		for (Entry<Item, AtomicInteger> entry : basketItems.entrySet()) {
			basketItem = entry.getKey();
			
            List<SpecialPrice> priceList = basketItem.getPrices();
            itemPendingQuantity = entry.getValue().get();
            for (SpecialPrice itemPrice : priceList) { 
            	if (entry.getValue().get() >= itemPrice.getQuantity() ) {
            		result += itemPrice.getPrice()*(entry.getValue().get() / itemPrice.getQuantity());
            		
            		itemPendingQuantity = entry.getValue().get() % itemPrice.getQuantity();
            		
            		entry.getValue().set(itemPendingQuantity);
            	}
			}
            if (itemPendingQuantity > 0) {
            	result += basketItem.getPrice() * itemPendingQuantity ;
            }

        }
		
		return result;
	}
	

}
