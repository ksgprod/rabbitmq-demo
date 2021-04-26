package br.com.ksgprod.factory;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.ksgprod.utils.RoutingTopology;

@Configuration
@EnableRabbit
public class TemplateFactory {
	
	@Bean()
    public RabbitTemplate directTemplateExchanger(CachingConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setExchange(RoutingTopology.DIRECT.getExchange());
        return template;
    }
	
	@Bean()
    public RabbitTemplate topicTemplateExchanger(CachingConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setExchange(RoutingTopology.TOPIC.getExchange());
        return template;
    }

}
