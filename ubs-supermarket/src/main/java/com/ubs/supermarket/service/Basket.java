package com.ubs.supermarket.service;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import com.ubs.supermarket.entity.Item;

public interface Basket {

	void addItem(Item item);

    void deleteItem(Item item);

    void clear();
    
    public Map<Item, AtomicInteger> getItems();
}
