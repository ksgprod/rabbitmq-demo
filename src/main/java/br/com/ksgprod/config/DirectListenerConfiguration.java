package br.com.ksgprod.config;

import static java.lang.Boolean.FALSE;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.ksgprod.jms.DirectListener;
import br.com.ksgprod.utils.RoutingTopology;

@Configuration
public class DirectListenerConfiguration {
	
	@Bean
	public SimpleMessageListenerContainer directListener(CachingConnectionFactory connectionFactory) {
		
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		DirectListener listener = new DirectListener();
		
		container.setConnectionFactory(connectionFactory);
		container.setQueueNames(RoutingTopology.DIRECT.getQueues());
		container.setMessageListener(listener);
		container.setDefaultRequeueRejected(FALSE);
		
		return container;
	}

}
