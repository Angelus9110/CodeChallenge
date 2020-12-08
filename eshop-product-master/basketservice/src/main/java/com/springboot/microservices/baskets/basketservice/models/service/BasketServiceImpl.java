package com.springboot.microservices.baskets.basketservice.models.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.springboot.microservices.baskets.basketservice.models.entity.Basket;
import com.springboot.microservices.baskets.basketservice.models.entity.Customer;
import com.springboot.microservices.baskets.basketservice.models.entity.Product;
import com.springboot.microservices.baskets.basketservice.models.repository.BasketRepository;
import com.springboot.microservices.baskets.basketservice.search.SearchResource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("serviceRestTemplate")
@Primary
public class BasketServiceImpl implements BasketService {

	private static final Logger logger = LoggerFactory.getLogger(BasketServiceImpl.class);

	@Autowired
	private RestTemplate restClient;

	@Autowired
	private BasketRepository basketRepository;

	@Override
	public Product findById(Long id) {
		Map<String, String> pathVariables = new HashMap<String, String>();
		pathVariables.put("id", id.toString());
		Product product = restClient.getForObject("http://localhost:8002/list/{id}", Product.class, pathVariables);
		return product;
	}

	@Override
	public Basket createOrder(SearchResource searchResource) {
		Customer customer =  new Customer();
		customer.setName(searchResource.getName());
		customer.setSurname(searchResource.getSurname());
		customer.setEmail(searchResource.getEmail());

		List<Product> phones = new ArrayList<>();
		int totalPrice = 0;
		for (Product product: searchResource.getPhones()){
			Product retrieveProduct = findById(product.getId());
			if(retrieveProduct != null && retrieveProduct.getPrice() > 0){
				phones.add(retrieveProduct);
				totalPrice = totalPrice + retrieveProduct.getPrice();
			}
		}
		Basket newOrder = new Basket(customer, phones);
		newOrder.setPrice(totalPrice);

		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		logger.info(gson.toJson(newOrder));

		return basketRepository.save(newOrder);
	}

}
