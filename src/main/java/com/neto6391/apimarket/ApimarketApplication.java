package com.neto6391.apimarket;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.neto6391.apimarket.domain.Category;
import com.neto6391.apimarket.domain.City;
import com.neto6391.apimarket.domain.Product;
import com.neto6391.apimarket.domain.State;
import com.neto6391.apimarket.repositories.CategoryRepository;
import com.neto6391.apimarket.repositories.CityRepository;
import com.neto6391.apimarket.repositories.ProductRepository;
import com.neto6391.apimarket.repositories.StateRepository;

@SpringBootApplication
public class ApimarketApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private StateRepository stateRepository;
	
	@Autowired
	private CityRepository cityRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ApimarketApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Informática");
		Category cat2 = new Category(null, "Escritorio");
		
		Product p1 = new Product(null, "Computador", 2000.00);
		Product p2 = new Product(null, "Impressora", 800.00);
		Product p3 = new Product(null, "Mouse", 80.00);
		
		cat1.getProducts().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProducts().addAll(Arrays.asList(p2));
		
		p1.getCategories().addAll(Arrays.asList(cat1));
		p2.getCategories().addAll(Arrays.asList(cat1, cat2));
		p3.getCategories().addAll(Arrays.asList(cat1));
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		productRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		State est1 = new State(null, "Minas Gerais");
		State est2 = new State(null, "São Paulo");
		
		City c1 = new City(null, "Unberlândia", est1);
		City c2 = new City(null, "São Paulo", est2);
		City c3 = new City(null, "Campinas", est2);
		
		est1.getCities().addAll(Arrays.asList(c1));
		est2.getCities().addAll(Arrays.asList(c2, c3));
		
		stateRepository.saveAll(Arrays.asList(est1, est2));
		cityRepository.saveAll(Arrays.asList(c1, c2, c3));
	}
	
	
}
