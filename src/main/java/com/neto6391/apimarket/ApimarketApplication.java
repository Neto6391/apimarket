package com.neto6391.apimarket;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.neto6391.apimarket.domain.Category;
import com.neto6391.apimarket.repositories.CategoryRepository;

@SpringBootApplication
public class ApimarketApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ApimarketApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Informática");
		Category cat2 = new Category(null, "Escritorio");
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		
	}
	
	
}
