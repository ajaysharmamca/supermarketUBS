package com.ubs.supermarket.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Component;

import com.ubs.supermarket.entity.Item;
import com.ubs.supermarket.service.Basket;

@Component
public class BasketImpl implements Basket {
	
    private Map<Item, AtomicInteger> items = new HashMap<Item, AtomicInteger>();
    
    public Map<Item, AtomicInteger> getItems() {
		return items;
	}

	public void addItem(Item item) {
    	items.putIfAbsent(item, new AtomicInteger(0));
    	items.get(item).incrementAndGet();
     }

    public void deleteItem(Item item) {
    	if (items.get(item) != null && items.get(item).get() > 0) {
    		items.get(item).decrementAndGet();
    	}
    }
    
    public void clear() {
        items.clear();
    }

 }
