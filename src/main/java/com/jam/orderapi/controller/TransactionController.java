package com.jam.orderapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.jam.orderapi.entity.Customer;
import com.jam.orderapi.entity.Transaction;
import com.jam.orderapi.entity.model.OrderRequest;
import com.jam.orderapi.entity.model.OrderResponse;
import com.jam.orderapi.entity.model.OrderResponse.Status;
import com.jam.orderapi.entity.service.CustomerService;
import com.jam.orderapi.entity.service.TransactionService;

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
	TransactionService transactionServiceImpl;

	@Autowired
	CustomerService customerServiceImpl;
	
/**
 * 
 * Rest endpoint that consumes the Payment API
 * Payment API - checks if the funds of the user is sufficient to spend for total price of the order
 *             - returns ORDER_ACCEPTED if sufficient, ORDER_NOT_ACCEPTED if otherwise
 * if the PaymentAPI returns ORDER_ACCEPTED, the price is deducted from the customer funds
 * records the transaction (regardless of the status)
 * replies with the list of all transactions 
 * 
 * @param orderRequest - an object that contains the Id of the user and the total price
 * @return - List of all previous transactions with its coresponding status 
 */
	@PostMapping("/ordernow")
	public List<Transaction> orderNow(@RequestBody OrderRequest orderRequest) {
		// ask the payment api
		final String PAYMENT_URI = "http://localhost:7071/paymentapi/checkorder";
		RestTemplate restTemplate = new RestTemplate();
		OrderResponse result = restTemplate.postForObject(PAYMENT_URI, orderRequest, OrderResponse.class);

		//extract order request
		Customer customer = customerServiceImpl.getCustomerById(orderRequest.getCustId()).get();
		Double curFunds = customer.getFunds();
		Double price = orderRequest.getPrice();
		//deduct the response if the Order is Accepted
		if (result.getResponse() == Status.ORDER_ACCEPTED) {
			customer.setFunds(curFunds - price);
			customerServiceImpl.addOrUpdateCustomer(customer);
		}
		// save the transaction
		transactionServiceImpl.createNewTransaction(new Transaction(customer, orderRequest.getPrice(), result.getResponse()));

		// then return all the transaction to the client
		return transactionServiceImpl.findTransactionsByCustomer(customer);
	}

	
	/**
	 * EXTRA:
	 * REST endpoint used in case the client has the transaction Id
	 * 
	 * @param transId
	 * @return list of transactions made by the requested customer
	 */
	@GetMapping("/gettrans/{transid}")
	public Optional<Transaction> getTransById(@PathVariable int transid) {
		return transactionServiceImpl.findTransactionById(transid);
	}

	/**
	 * EXTRA:
	 * ENDPOINT FOR TESTING/DEBUGGING
	 * 
	 * @return list of transactions for juan dela cruz
	 */
	@GetMapping("/gettrans")
	public List<Transaction> getTrans() {
		Customer cust = new Customer(4, "Juan Dela Cruz", 56.9);
		return transactionServiceImpl.findTransactionsByCustomer(cust);
	}

}
