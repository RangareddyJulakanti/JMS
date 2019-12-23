package com.ranga.jms.spring.service;

import com.ranga.jms.spring.model.Product;

public interface OrderService {

	public void processOrder(Product product);
}
