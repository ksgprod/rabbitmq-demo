package br.com.ksgprod.strategy;

import org.springframework.stereotype.Component;

import br.com.ksgprod.helper.DirectProducerHelper;
import br.com.ksgprod.jms.payload.MessagePayload;
import br.com.ksgprod.utils.Constants;

@Component(Constants.DIRECT_TOPOLOGY_STRATEGY)
public class DirectTopologyStrategy implements TopologyStrategy {
	
	private DirectProducerHelper helper;
	
	public DirectTopologyStrategy(DirectProducerHelper helper) {
		this.helper = helper;
	}

	@Override
	public void sendMessage(MessagePayload payload) {
		this.helper.doNotify(payload.toString());
	}

}
