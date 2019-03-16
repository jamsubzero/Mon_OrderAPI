package com.jam.orderapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jam.orderapi.entity.Customer;
import com.jam.orderapi.entity.Transaction;
import com.jam.orderapi.entity.service.TransactionServiceImpl;

/**
 * this API provides access to transaction/Orders info made by the user
 *  
 * @author jamsubzero
 *
 */
@RestController
@RequestMapping("/transapi")
public class TransactionController {
	
	@Autowired
	TransactionServiceImpl transactionServiceImpl;
		
	/**
	 * FOR TESTING/DEBUGGING
	 * 
	 * @return list of transactions for juan dela cruz
	 */
	@GetMapping("/gettrans")
	public List<Transaction> getTrans(){
		Customer cust = new Customer(4, "Juan Dela Cruz", 56.9);
		return transactionServiceImpl.findTransactionsByCustomer(cust);
	}
	
	
	
	/**
	 * REST endpoint used in case the client has the transaction Id
	 * 
	 * @param transId
	 * @return list of transactions made by the requested customer
	 */
	@GetMapping("/gettrans/{transid}")
	public Optional<Transaction> getTransById(@PathVariable int transid){
		return transactionServiceImpl.findTransactionById(transid);
	}
	
}
