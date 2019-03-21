package com.jam.orderapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jam.orderapi.entity.Customer;
import com.jam.orderapi.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer>{

	List<Transaction> findTransactionsByCustomer(Customer customer); //in case the customer object is available
	 
	 
}
