package com.springboot.microservices.products.productservice.models.service;

import com.springboot.microservices.products.productservice.models.entity.Product;
import com.springboot.microservices.products.productservice.models.repository.ProductRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Product> findAll() {

		List<Product> productList = (List<Product>) productRepository.findAll();
		ArrayList products = new ArrayList();
		for (Product product: productList){
			products.add(product.getName() + " : " + product.getPrice() + " : " + product.getId());
		}
		return products;
	}

	@Override
	@Transactional(readOnly = true)
	public Product findById(Long id) {
		return productRepository.findById(id).orElse(null);
	}

}
