package com.jam.orderapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jam.orderapi.entity.Product;
import com.jam.orderapi.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	
	@Autowired
	ProductRepository productRepository;
	
	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	
	
	
}
