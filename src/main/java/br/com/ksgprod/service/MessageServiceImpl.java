package br.com.ksgprod.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import br.com.ksgprod.controller.request.MessageRequest;
import br.com.ksgprod.factory.topology.TopologyStrategyFactory;
import br.com.ksgprod.jms.payload.MessagePayload;
import br.com.ksgprod.strategy.TopologyStrategy;

@Service
public class MessageServiceImpl implements MessageService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MessageServiceImpl.class);
	
	private TopologyStrategyFactory topologyStrategyFactory;
	
	public MessageServiceImpl(TopologyStrategyFactory topologyStrategyFactory) {
		this.topologyStrategyFactory = topologyStrategyFactory;
	}

	@Override
	public void sendMessage(MessageRequest request) {
		
		MessagePayload payload = MessagePayload.builder(request);
		
		LOGGER.info("stage=init method=MessageServiceImpl.sendMessage payload={}", payload);
		
		TopologyStrategy strategy = this.topologyStrategyFactory.getStrategy(request.getTopology());
		strategy.sendMessage(payload);
		
		LOGGER.info("stage=end method=MessageServiceImpl.sendMessage response=void");
		
	}

}
