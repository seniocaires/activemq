package simples.messagedrivenbeans;

/*
Note that the MyMessageProcessor class implements both the Message-DrivenBean 
interface and the MessageListener interface. The MessageDrivenBean
interface requires an implementation of the setMessageDrivenContext() method
and the ejbRemove() method. Each of these methods is invoked by the EJB container
for the purposes of creation and destruction of the MDB . The MessageListener interface 
contains only a single method named onMessage() . The onMessage() method is
invoked automatically by the JMS provider when a message arrives in a destination on
which the MDB is registered.
In addition to allowing the EJB container to manage all necessary resources including Java EE 
resources (such as JDBC , JMS , and JCA connections), security, transactions,
and even JMS message acknowledgement, one of the biggest advantages of MDB s is
that they can process messages concurrently. Not only do typical JMS clients need to
manually manage their own resources and environment, but they’re usually built for
processing messages serially—one at a time (unless they’re specifically built with concurrency 
in mind). Instead of processing messages one at a time, MDB s can process
multiple messages at the same time because the EJB container can create as many
instances of the MDB s as are allowed by the EJB ’s deployment descriptor. Such configuration 
is typically specific to the Java EE container. If you’re using a Java EE container
for this, consult the documentation for the container on how this is configured in the
EJB deployment descriptor.

A disadvantage of MDB s is their requirement of a full Java EE container. Just about
every EJB container available today can support MDB s only if the entire Java EE con-
tainer is used. MDB s are extremely useful when using a full Java EE container, but
there’s an alternative that doesn’t require the full Java EE container. Using the Spring
Framework’s JMS API s makes developing message-driven POJO s ( MDP s) easy. These are
Plain Old Java Objects ( POJO s) that act as if they’re message driven. This style of devel-
opment has become popular in the Java development community because it avoids
the overhead of using a full Java EE container. Such development with the Spring
Framework.

Not every EJB container requires a full Java EE container—try OpenEJB
At the time of this writing, nearly all EJB containers on the market require a full Java EE
container to support MDBs. The exception to this rule is Apache OpenEJB (http://
openejb.apache.org/). OpenEJB supports MDBs from the EJB 1.1 spec, the EJB 2
spec, and the EJB 3 spec in OpenEJB’s embedded mode as well as in its standalone
mode. OpenEJB can be embedded inside of Apache Geronimo (http://geronimo.
apache.org/), Apache Tomcat (http://tomcat.apache.org/), or your own Java applica-
tion and will still provide support for MDBs.
 */
/*
import javax.ejb.EJBException;
import javax.ejb.MessageDrivenBean;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class MyMessageProcessor implements MessageDrivenBean, MessageListener {

	public void onMessage(Message message) {
		TextMessage textMessage = null;
		try {
			if (message instanceof TextMessage) {
				textMessage = (TextMessage) message;
				System.out.println("Received message: " + msg.getText());
				processMessage(textMessage);
			} else {
				System.out.println("Incorrect message type: " + message.getClass().getName());
			}
		} catch (JMSException jmsEx) {
			jmsEx.printStackTrace();
		}
	}

	public void ejbRemove() throws EJBException {
		// This method is called by the EJB container
	}

	public void setMessageDrivenContext(MessageDrivenContext ctx) throws EJBException {
		// This method is called by the EJB container
	}

	private void processMessage(TextMessage textMessage) {
		// Do some important processing of the message here
	}
}*/

public class MyMessageProcessor {

}
