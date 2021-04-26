package br.com.ksgprod.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

import com.google.gson.Gson;

import br.com.ksgprod.jms.payload.MessagePayload;

public class TopicSecondListener implements MessageListener {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TopicSecondListener.class);

	@Override
	public void onMessage(Message message) {

		LOGGER.info("stage=init method=TopicSecondListener.onMessage message=Listening to message.");
		
		String messageBody = new String(message.getBody());
		MessagePayload payload = new Gson().fromJson(messageBody, MessagePayload.class);
		
		LOGGER.info("stage=end method=TopicSecondListener.onMessage payload={}", payload);
		
	}

}
