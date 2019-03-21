package com.jam.orderapi.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jam.orderapi.entity.Customer;
import com.jam.orderapi.service.CustomerService;

/**
 * This API is to provide user access to customer details
 * 
 * @author jamsubzero
 */
@RestController
@RequestMapping("/custapi")
public class CustomerController {
	
	@Autowired
	CustomerService customerServiceImpl;
	
	/**
	 * EXTRA:
	 * REST endpoint in case we need to check the customer details (i.e. name & funds)
	 * 
	 * @param id - the customer id in the path variable
	 * @return customer object
	 */
	@GetMapping("/getcustomer/{id}")
	public Optional<Customer> getCustomer(@PathVariable int id){
		return customerServiceImpl.getCustomerById(id);
	}
	
	
}
