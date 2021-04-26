package br.com.ksgprod.strategy;

import org.springframework.stereotype.Component;

import br.com.ksgprod.helper.TopicProducerHelper;
import br.com.ksgprod.jms.payload.MessagePayload;
import br.com.ksgprod.utils.Constants;

@Component(Constants.TOPIC_TOPOLOGY_STRATEGY)
public class TopicTopologyStrategy implements TopologyStrategy {

	private TopicProducerHelper helper;
	
	public TopicTopologyStrategy(TopicProducerHelper helper) {
		this.helper = helper;
	}

	@Override
	public void sendMessage(MessagePayload payload) {
		this.helper.doNotify(payload.toString());
	}

}
