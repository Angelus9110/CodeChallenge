package com.springboot.microservices.baskets.basketservice.search;

import com.springboot.microservices.baskets.basketservice.models.entity.Product;
import java.util.ArrayList;
import java.util.List;

public class SearchResource {
  private String name;
  private String surname;
  private String email;
  private ArrayList<Product> phones;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public List<Product> getPhones() {
    return phones;
  }

  public void setPhones(
      ArrayList<Product> phones) {
    this.phones = phones;
  }
}
