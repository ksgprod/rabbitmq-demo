package br.com.ksgprod.helper;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import br.com.ksgprod.utils.RoutingTopology;

@Component
public class TopicProducerHelper {

	@Autowired
	@Qualifier("topicTemplateExchanger")
	private RabbitTemplate rabbitTemplate;

	public void doNotify(String message) {

		Message messageSend = MessageBuilder.withBody(message.getBytes()).build();
		this.rabbitTemplate.send(RoutingTopology.TOPIC.getBind(), messageSend);

	}

}
