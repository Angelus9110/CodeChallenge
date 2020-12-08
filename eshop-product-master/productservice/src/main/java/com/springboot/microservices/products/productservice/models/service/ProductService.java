package com.springboot.microservices.products.productservice.models.service;

import com.springboot.microservices.products.productservice.models.entity.Product;

import java.util.List;

public interface ProductService {

	public List<Product> findAll();
	public Product findById(Long id);
}
