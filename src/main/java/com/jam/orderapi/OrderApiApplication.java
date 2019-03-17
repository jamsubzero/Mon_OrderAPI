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

@SpringBootApplication
public class OrderApiApplication implements CommandLineRunner{
	
	private static final Logger MYLOGGER = Logger.getLogger(OrderApiApplication.class.getName());
	
	@Autowired
	ProductRepository productRepository; 
	
	@Autowired
	CustomerRepository customerRepository; 
	
	@Autowired
	TransactionRepository transactionRepository;
	

	public static void main(String[] args) {
		SpringApplication.run(OrderApiApplication.class, args);
	}
	
	/**
	 * TODO remove this before production
	 * 
	 * This is to insert these dummy data
	 */
	@Override
	public void run(String... args) throws Exception {
		// Adding dummy products, keep the object reference for later usage
		Product prod = new Product(1, "T-Shirt", "this is a tshirt", 25.9); 
		Product prod2 = new Product(2, "Jean", "this is a jeans", 423.9); 
		Product prod3 = new Product(3, "Hat", "this is a hat", 5.0);
		productRepository.save(prod);
		productRepository.save(prod2);
		productRepository.save(prod3);
		
		// Adding dummy customer, keep the object reference for later usage
		// this is like a customer sign-up
		//int custid, String name, Double funds
		Customer cust = new Customer(4, "Juan", 23.4); // I want to use this object later to add trans
		Customer cust2 = new Customer(5, "Pedro", 23.4);
		Customer cust3 = new Customer(6, "Jose", 23.4);
		customerRepository.save(cust);
		customerRepository.save(cust2);
		customerRepository.save(cust3);
		
		// Add 2 new transactions for the same customer, keep the object reference to used for adding the selected items
		//(int transid, Customer customer, Double totalprice, int status)
		Transaction trans = new Transaction(7, cust, 45.8, 0);
		Transaction trans2 = new Transaction(8, cust, 45.8, 0);
		transactionRepository.save(trans);
		transactionRepository.save(trans2);
		
		//adding 2 items to cart, -> for the same transaction, with different products and qty
		//(Transaction transaction, Product product, int quantity)
//		cartItemsRepository.save(new CartItems(trans, prod, 5));
//		cartItemsRepository.save(new CartItems(trans, prod2, 89));

		
	}

}
