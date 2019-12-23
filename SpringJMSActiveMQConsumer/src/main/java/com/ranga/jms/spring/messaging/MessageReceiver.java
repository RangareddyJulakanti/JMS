package com.ranga.jms.spring.messaging;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import com.ranga.jms.spring.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import com.ranga.jms.spring.service.OrderService;

@Component
public class MessageReceiver implements MessageListener{

	static final Logger LOG = LoggerFactory.getLogger(MessageReceiver.class);
	
	@Autowired
	MessageConverter messageConverter;
	
	@Autowired
	OrderService orderService;

	
	@Override
	public void onMessage(Message message) {
		try {
			LOG.info("-----------------------------------------------------");
			Product product = (Product) messageConverter.fromMessage(message);
			LOG.info("Application : order received : {}",product);	
			orderService.processOrder(product);
			LOG.info("-----------------------------------------------------");
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

