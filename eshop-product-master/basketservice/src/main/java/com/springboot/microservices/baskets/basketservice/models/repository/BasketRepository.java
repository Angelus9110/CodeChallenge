package com.springboot.microservices.baskets.basketservice.models.repository;

import com.springboot.microservices.baskets.basketservice.models.entity.Basket;
import org.springframework.data.repository.CrudRepository;

public interface BasketRepository extends CrudRepository<Basket, Long> {

}
