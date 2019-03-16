package com.jam.orderapi.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jam.orderapi.entity.POJO.ClientOrder;
import com.jam.orderapi.entity.POJO.Item;

@RestController
@RequestMapping("/orderapi")
public class OrderController {

	@GetMapping("/placeorder")
	public ClientOrder placeOrder() {
		ClientOrder sampleorder = new ClientOrder(
				4, Arrays.asList(
						new Item(1, 12), 
						new Item(2, 7), 
						new Item(3, 3)));
		return sampleorder;
	}

}
