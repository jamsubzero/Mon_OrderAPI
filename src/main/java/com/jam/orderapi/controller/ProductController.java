package com.jam.orderapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jam.orderapi.entity.Product;
import com.jam.orderapi.entity.service.ProductServiceImpl;

/**
 * This API used to get the available products
 * 
 * @author jamsubzero
 *
 */

@RestController
@RequestMapping("/orderapi")
public class ProductController {
	
	
	@Autowired
	ProductServiceImpl productServiceImpl;
	/**
	 * REST endpoint that returns the products encoded in the database
	 * The products returned are fixed values persisted when the app starts
	 * 
	 * @return list of products
	 */
	
	@GetMapping("/getallproducts")
	public List<Product> getProducts(){
		return productServiceImpl.getAllProducts();
	}

	
	

}
