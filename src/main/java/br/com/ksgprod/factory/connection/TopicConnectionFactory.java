package br.com.ksgprod.factory.connection;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.ksgprod.utils.RoutingTopology;

@Configuration
public class TopicConnectionFactory {
	
	@Bean
	public RabbitAdmin topicRabbitAdmim(CachingConnectionFactory connectionFactory) {
		
		RabbitAdmin admin = new RabbitAdmin(connectionFactory);
		TopicExchange exchange = new TopicExchange(RoutingTopology.TOPIC.getExchange());
		
		admin.declareExchange(exchange);
		
		// declarando e configurando bind para primeira fila do topico
		Queue firstQueue = new Queue(RoutingTopology.TOPIC.getQueues()[0]);
		Binding firstBinding = BindingBuilder.bind(firstQueue).to(exchange).with(RoutingTopology.TOPIC.getBind());
		
		admin.declareQueue(firstQueue);
		admin.declareBinding(firstBinding);
		
		// declarando e configurando bind para segunda fila do topico
		Queue secondQueue = new Queue(RoutingTopology.TOPIC.getQueues()[1]);
		Binding secondBinding = BindingBuilder.bind(secondQueue).to(exchange).with(RoutingTopology.TOPIC.getBind());
		
		admin.declareQueue(secondQueue);
		admin.declareBinding(secondBinding);
		
		return admin;
		
	}

}
