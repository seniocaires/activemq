package simples;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class MyAsyncMessageConsumer implements MessageListener {

	public void onMessage(Message message) {
		if (message instanceof TextMessage) {
			System.out.println("Received message: " + message);
		}		
	}
	
	public static void main(String[] args) throws JMSException {
		ActiveMQConnectionFactory factory = null;
		Connection connection = null;
		Session session = null;
		Destination destination;
		MessageConsumer consumer = null;
		boolean useTransaction = false;
		try {

			factory = new ActiveMQConnectionFactory("tcp://0.0.0.0:61616");

			connection = factory.createConnection("admin", "admin");
			connection.start();
			session = connection.createSession(useTransaction, Session.AUTO_ACKNOWLEDGE);
			destination = session.createQueue("TEST.QUEUE");
			consumer = session.createConsumer(destination);
			consumer.setMessageListener(new MyAsyncMessageConsumer());
		} catch (JMSException jmsEx) {
			jmsEx.printStackTrace();
		} finally {
			if (consumer != null) {
				consumer.close();
			}
			if (session != null) {
				session.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
	}

}
