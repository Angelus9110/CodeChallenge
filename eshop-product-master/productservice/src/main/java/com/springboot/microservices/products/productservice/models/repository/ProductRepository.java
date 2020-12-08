package com.springboot.microservices.products.productservice.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.springboot.microservices.products.productservice.models.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{

}
