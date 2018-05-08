package ch3.portfolio;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Consumer {

    private static String brokerURL = "tcp://0.0.0.0:61616";
    private static transient ConnectionFactory factory;
    private transient Connection connection;
    private transient Session session;
    
    public Consumer() throws JMSException {
    	factory = new ActiveMQConnectionFactory(brokerURL);
    	connection = factory.createConnection();
        connection.start();
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
    }
    
    public void close() throws JMSException {
        if (connection != null) {
            connection.close();
        }
    }    

    public void addStockDestination(String stock) throws JMSException {
    	Destination destination = session.createTopic("STOCKS." + stock);
		MessageConsumer messageConsumer = session.createConsumer(destination);
		messageConsumer.setMessageListener(new Listener());
    }

    public static void main(String[] args) throws JMSException {
    	Consumer consumer = new Consumer();
    	for (String stock : args) {
    		consumer.addStockDestination(stock);
    	}
    }
	
	public Session getSession() {
		return session;
	}

}
