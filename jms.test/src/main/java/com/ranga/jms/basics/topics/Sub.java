package com.ranga.jms.basics.topics;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Sub {
	// URL of the JMS server
		private static String url = "tcp://localhost:61616";
	// default broker URL is : tcp://localhost:61616"

	// Name of the queue we will receive messages from
		private static String subject = "JCG_TOPIC";

		public static void main(String[] args) throws JMSException {
			// Getting JMS connection from the server
			ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
			Connection connection = connectionFactory.createConnection();
			connection.start();

			// Creating session for seding messages
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

			// Getting the queue 'JCG_QUEUE'
			Destination destination = session.createTopic(subject);

			// MessageConsumer is used for receiving (consuming) messages
			MessageConsumer consumer1 = session.createConsumer(destination);
			//MessageConsumer consumer2 = session.createConsumer(destination);

			// Here we receive the message.
			Message message1 = consumer1.receive();
		//	Message message2 = consumer2.receive();
			// We will be using TestMessage in our example. MessageProducer sent us a
			// TextMessage
			// so we must cast to it to get access to its .getText() method.
			if (message1 instanceof TextMessage) {
				TextMessage textMessage = (TextMessage) message1;
				System.out.println("Received message1 '" + textMessage.getText() + "'");
			}
//			if (message2 instanceof TextMessage) {
//				TextMessage textMessage = (TextMessage) message2;
//				System.out.println("Received message2 '" + textMessage.getText() + "'");
//			}
			connection.close();
		}
}
