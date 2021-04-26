package br.com.ksgprod.strategy;

import br.com.ksgprod.jms.payload.MessagePayload;

public interface TopologyStrategy {
	
	public void sendMessage(MessagePayload payload);

}
