package simples;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.naming.NamingException;

import org.apache.activemq.ActiveMQConnectionFactory;

public class MyMessageProducer {

	public static void main(String[] args) throws NamingException, JMSException {
		ActiveMQConnectionFactory factory = null;
		Connection connection = null;
		Session session = null;
		Destination destination;
		MessageProducer producer = null;
		Message message;
		boolean useTransaction = false;
		try {

			factory = new ActiveMQConnectionFactory("tcp://0.0.0.0:61616");

			connection = factory.createConnection("admin", "admin");
			connection.start();
			session = connection.createSession(useTransaction, Session.AUTO_ACKNOWLEDGE);
			destination = session.createQueue("TEST.QUEUE");
			producer = session.createProducer(destination);
			message = session.createTextMessage("this is a test");
			producer.send(message);
		} catch (JMSException jmsEx) {
			jmsEx.printStackTrace();
		} finally {
			if (producer != null) {
				producer.close();
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
