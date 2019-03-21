package com.jam.orderapi.service;

import java.util.List;
import java.util.Optional;

import com.jam.orderapi.entity.Transaction;
import com.jam.orderapi.model.OrderRequest;

public interface TransactionService {

	Optional<Transaction> findTransactionById(int transId); //when the client has the transaction id
	List<Transaction> orderNow(OrderRequest orderRequest);
}
