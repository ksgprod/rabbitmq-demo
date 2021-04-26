package br.com.ksgprod.factory.connection;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.ksgprod.utils.RoutingTopology;

@Configuration
public class DirectConnectionFactory {
	
	@Bean
	public RabbitAdmin directRabbitAdmim(CachingConnectionFactory connectionFactory) {
		
		RabbitAdmin admin = new RabbitAdmin(connectionFactory);
		DirectExchange exchange = new DirectExchange(RoutingTopology.DIRECT.getExchange());
		Queue queue = new Queue(RoutingTopology.DIRECT.getQueues()[0]);
		Binding binding = BindingBuilder.bind(queue).to(exchange).with(RoutingTopology.DIRECT.getBind());
		
		admin.declareExchange(exchange);
		admin.declareQueue(queue);
		admin.declareBinding(binding);
		
		return admin;
		
	}

}
