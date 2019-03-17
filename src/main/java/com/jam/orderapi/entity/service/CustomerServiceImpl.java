package com.jam.orderapi.entity.service;




import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jam.orderapi.entity.Customer;
import com.jam.orderapi.entity.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
 

	@Override
	public Optional<Customer> getCustomerById(int custid) {
		return customerRepository.findById(custid);
	}


	@Override
	public Customer addOrUpdateCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

}
