package com.springboot.microservices.baskets.basketservice.models.entity;


import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Basket")
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Customer customer;

    @Column(name = "price")
    private int price;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "Products_id", referencedColumnName = "id")
    private List<Product> phones;

    public Basket(){};

    public Basket(Product product) {
    }

    public Basket(Customer customer, List<Product> phones) {
        this.customer = customer;
        this.phones = phones;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(
        Customer customer) {
        this.customer = customer;
    }

    public List<Product> getPhones() {
        return phones;
    }

    public void setPhones(
        List<Product> phones) {
        this.phones = phones;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
