package com.springboot.microservices.baskets.basketservice.models.service;


import com.springboot.microservices.baskets.basketservice.models.entity.Basket;
import com.springboot.microservices.baskets.basketservice.models.entity.Product;
import com.springboot.microservices.baskets.basketservice.search.SearchResource;

public interface BasketService {

    public Product findById(Long id);
    public Basket createOrder(SearchResource searchResource);
}
