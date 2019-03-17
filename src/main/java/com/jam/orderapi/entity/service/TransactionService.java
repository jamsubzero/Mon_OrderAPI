package com.jam.orderapi.entity.service;

import java.util.List;
import java.util.Optional;

import com.jam.orderapi.entity.Customer;
import com.jam.orderapi.entity.Transaction;

public interface TransactionService {

	List<Transaction> findTransactionsByCustomer(Customer customer); //in case the customer object is available
	Optional<Transaction> findTransactionById(int transId); //when the client has the transaction id
	Transaction createNewTransaction(Transaction transaction);
}
