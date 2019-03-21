package com.jam.orderapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jam.orderapi.entity.Customer;
import com.jam.orderapi.entity.Transaction;
import com.jam.orderapi.model.OrderRequest;
import com.jam.orderapi.model.OrderResponse;
import com.jam.orderapi.model.OrderResponse.Status;
import com.jam.orderapi.repository.CustomerRepository;
import com.jam.orderapi.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionRepository transactionRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public Optional<Transaction> findTransactionById(int transid) {
		return transactionRepository.findById(transid);
	}


	@Override
	public List<Transaction> orderNow(OrderRequest orderRequest) {
		// =========================================
		// ask the payment api
		final String PAYMENT_URI = "http://localhost:7071/paymentapi/checkorder";
		RestTemplate restTemplate = new RestTemplate();
		OrderResponse result = restTemplate.postForObject(PAYMENT_URI, orderRequest, OrderResponse.class);

		// extract order request
		Optional<Customer> customer = customerRepository.findById(orderRequest.getCustId());
		if (customer.isPresent()) {
			Double curFunds = customer.get().getFunds();
			Double price = orderRequest.getPrice();
			// deduct the response if the Order is Accepted
			if (result.getResponse() == Status.ORDER_ACCEPTED) {
				customer.get().setFunds(curFunds - price);
				customerRepository.save(customer.get());
			}
		}
		// save the transaction
		transactionRepository.save(new Transaction(customer.get(), orderRequest.getPrice(), result.getResponse()));

		// then return all the transaction to the client
		return transactionRepository.findTransactionsByCustomer(customer.get());
	}

}
