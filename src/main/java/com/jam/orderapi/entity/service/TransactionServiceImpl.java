package com.jam.orderapi.entity.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jam.orderapi.entity.Customer;
import com.jam.orderapi.entity.Transaction;
import com.jam.orderapi.entity.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService{
	
	@Autowired
	TransactionRepository transactionRepository;

	@Override
	public List<Transaction> findTransactionsByCustomer(Customer customer) {
		return transactionRepository.findTransactionsByCustomer(customer);
	}

	@Override
	public Optional<Transaction> findTransactionById(int transid) {
		return transactionRepository.findById(transid);
	}
	
	

}
