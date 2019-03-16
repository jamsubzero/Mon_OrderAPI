package com.jam.orderapi.entity.service;


import java.util.Optional;

import com.jam.orderapi.entity.Customer;

public interface CustomerService {

	Optional<Customer> getCustomerById(int custid);

}
