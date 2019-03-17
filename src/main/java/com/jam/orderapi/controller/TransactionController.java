package com.jam.orderapi.controller;

import java.util.List;
import java.util.Optional;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jam.orderapi.OrderApiApplication;
import com.jam.orderapi.entity.Customer;
import com.jam.orderapi.entity.Transaction;
import com.jam.orderapi.entity.POJO.OrderRequest;
import com.jam.orderapi.entity.repository.CustomerRepository;
import com.jam.orderapi.entity.service.CustomerServiceImpl;
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
	
	private static final Logger LOGGER = Logger.getLogger(TransactionController.class.getName());
	
	@Autowired
	TransactionServiceImpl transactionServiceImpl;
	
	@Autowired
	CustomerServiceImpl customerServiceImpl;

//TODO validating the order must be done in the other API
	@PostMapping("/ordernow")
	public List<Transaction> onrderNow(@RequestBody OrderRequest orderRequest){
		Customer customer = customerServiceImpl.getCustomerById(orderRequest.getCustId()).get();
		Double curFunds = customer.getFunds();
		Double price = orderRequest.getPrice();
		LOGGER.infof("funds: {}", curFunds);
		int status = 0; //rejected by default
		if( price <= curFunds ) {
			status = 1; // accepted
			//TODO subtract the user
			customer.setFunds(curFunds - price);
			customerServiceImpl.addOrUpdateCustomer(customer);
		}
		//Customer customer, Double totalprice, int status
		//save the transaction
		transactionServiceImpl.createNewTransaction(new Transaction(customer, orderRequest.getPrice(), status));
	
		//then return all the transaction to the client
		return transactionServiceImpl.findTransactionsByCustomer(customer);
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
	
	
	
}
