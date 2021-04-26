package br.com.ksgprod.config;

import static java.lang.Boolean.FALSE;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.ksgprod.jms.TopicFirstListener;
import br.com.ksgprod.jms.TopicSecondListener;
import br.com.ksgprod.utils.RoutingTopology;

@Configuration
public class TopicListenerConfiguration {
	
	@Bean
	public SimpleMessageListenerContainer topicFirstListener(CachingConnectionFactory connectionFactory) {
		
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		TopicFirstListener listener = new TopicFirstListener();
		String firstQueue = RoutingTopology.TOPIC.getQueues()[0];
		
		container.setConnectionFactory(connectionFactory);
		container.setQueueNames(firstQueue);
		container.setMessageListener(listener);
		container.setDefaultRequeueRejected(FALSE);
		
		return container;
	}
	
	@Bean
	public SimpleMessageListenerContainer topicSecondListener(CachingConnectionFactory connectionFactory) {
		
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		TopicSecondListener listener = new TopicSecondListener();
		String secondQueue = RoutingTopology.TOPIC.getQueues()[1];
		
		container.setConnectionFactory(connectionFactory);
		container.setQueueNames(secondQueue);
		container.setMessageListener(listener);
		container.setDefaultRequeueRejected(FALSE);
		
		return container;
	}

}
