package com.neto6391.apimarket.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neto6391.apimarket.domain.Product;



public interface ProductRepository extends JpaRepository<Product, Integer> {

}
