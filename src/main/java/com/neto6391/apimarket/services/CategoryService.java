package com.neto6391.apimarket.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neto6391.apimarket.domain.Category;
import com.neto6391.apimarket.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repo;
	
	public Category search(Integer id) {
		Optional<Category> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
}
