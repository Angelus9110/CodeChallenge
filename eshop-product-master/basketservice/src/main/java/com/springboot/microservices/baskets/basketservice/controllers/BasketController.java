package com.springboot.microservices.baskets.basketservice.controllers;

import com.springboot.microservices.baskets.basketservice.models.entity.Basket;
import com.springboot.microservices.baskets.basketservice.models.service.BasketService;
import com.springboot.microservices.baskets.basketservice.search.SearchResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasketController {

  private static Logger logger = LoggerFactory.getLogger(BasketController.class);

  @Autowired
  private BasketService basketService;

  @PostMapping(value = "/newBasketOrder", consumes = "application/json", produces = "application/json")
  public ResponseEntity createBasketOrder(@RequestBody SearchResource searchResource) {

    Basket basket = basketService.createOrder(searchResource);

    if (basket != null) {
      return new ResponseEntity<>(HttpStatus.OK);
    } else {

      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }
}
