package com.jam.orderapi.service;




import java.util.Optional;

import com.jam.orderapi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jam.orderapi.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
    CustomerRepository customerRepository;
 
	@Override
	public Optional<Customer> getCustomerById(int custid) {
		return customerRepository.findById(custid);
	}

}
