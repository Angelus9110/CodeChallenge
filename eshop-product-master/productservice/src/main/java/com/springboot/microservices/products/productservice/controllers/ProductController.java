package com.springboot.microservices.products.productservice.controllers;

import com.springboot.microservices.products.productservice.models.entity.Product;
import com.springboot.microservices.products.productservice.models.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController{

	@Autowired
	private ProductService productService;
	
	@GetMapping("/list")
	public List<Product> listProducts(){
		return productService.findAll();
	}
	
	@GetMapping("/list/{id}")
	public Product product(@PathVariable Long id) throws Exception {
		return productService.findById(id);
	}

}
