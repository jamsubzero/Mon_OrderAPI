package com.jam.orderapi.model;

public class OrderResponse {

	public static enum Status{
		 ORDER_ACCEPTED, ORDER_NOT_ACCEPTED
	}
	
	Status answer;

	public OrderResponse() {
	}

	public OrderResponse(Status answer) {
		this.answer = answer;
	}

	public Status getResponse() {
		return answer;
	}

	public void setResponse(Status answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "OrderResponse [answer=" + answer + "]";
	}

	
	
	
}

