package com.jam.orderapi;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jam.orderapi.entity.Customer;
import com.jam.orderapi.entity.Product;
import com.jam.orderapi.entity.Transaction;
import com.jam.orderapi.entity.repository.CustomerRepository;
import com.jam.orderapi.entity.repository.ProductRepository;
import com.jam.orderapi.entity.repository.TransactionRepository;
import com.jam.orderapi.entity.service.TransactionServiceImpl;;

@SpringBootApplication
public class OrderApiApplication implements CommandLineRunner{
	
	@Autowired
	ProductRepository productRepository; 
	
	@Autowired
	CustomerRepository customerRepository; 
	
	@Autowired
	TransactionRepository transactionRepository;
	
	@Autowired
	TransactionServiceImpl transactionServiceImpl;
	
	private final Logger LOGGER = Logger.getLogger(OrderApiApplication.class.getName());

	public static void main(String[] args) {
		SpringApplication.run(OrderApiApplication.class, args);
	}
	
	/**
	 * This is to insert these dummy data
	 */
	@Override
	public void run(String... args) throws Exception {
		productRepository.save(new Product("T-Shirt", "this is a tshirt", 25.9));
		productRepository.save(new Product("Jean", "this is a jeans", 423.9));
		productRepository.save(new Product("Hat", "this is a hat", 5.0));
		
		customerRepository.save( new Customer("Juan", 2.4) );
		customerRepository.save(new Customer("Pedro", 233.4));
		customerRepository.save(new Customer("Jose", 234.44));
		
		Customer cust = new Customer(4, "Juan", 23.4); // I want to use this object later to add trans
		transactionRepository.save(new Transaction(cust, 45.8, 0));
		transactionRepository.save(new Transaction(cust, 35.8, 7));
		
	}

}
