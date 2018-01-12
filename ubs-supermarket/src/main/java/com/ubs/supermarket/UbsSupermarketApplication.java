package com.ubs.supermarket;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ubs.supermarket.entity.Item;
import com.ubs.supermarket.service.ItemRepository;

@SpringBootApplication
public class UbsSupermarketApplication implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ItemRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(UbsSupermarketApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
//		Item item = repository.findById(1L);
//		
//		logger.info("Item 1 -> {}", item);
//		repository.save(new Item("E", new BigDecimal(50.00)));
	
	}
}
