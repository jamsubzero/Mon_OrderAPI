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

import com.jam.orderapi.entity.Transaction;
import com.jam.orderapi.model.OrderRequest;
import com.jam.orderapi.service.TransactionService;

import io.swagger.annotations.ApiOperation;

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
	@ApiOperation(value = "Process the order then returns all previous transactions with the status" )
	@PostMapping("/ordernow")
	public List<Transaction> orderNow(@RequestBody OrderRequest orderRequest) {
		return transactionServiceImpl.orderNow(orderRequest);
	}

	
	/**
	 * EXTRA FOR DEBUGGING
	 * REST endpoint used in case the client has the transaction Id
	 * 
	 * @param transId
	 * @return list of transactions made by the requested customer
	 */
	@ApiOperation(value = "Returns a Transaction based on the given ID" )
	@GetMapping("/gettrans/{transid}")
	public Optional<Transaction> getTransById(@PathVariable int transid) {
		return transactionServiceImpl.findTransactionById(transid);
	}

	

}
