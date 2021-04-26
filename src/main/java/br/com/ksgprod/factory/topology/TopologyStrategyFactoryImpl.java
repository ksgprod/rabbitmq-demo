package br.com.ksgprod.factory.topology;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import br.com.ksgprod.strategy.TopologyStrategy;
import br.com.ksgprod.utils.Constants;
import br.com.ksgprod.utils.RoutingTopology;

@Component
public class TopologyStrategyFactoryImpl implements TopologyStrategyFactory {
	
	@Autowired
	@Qualifier(Constants.DIRECT_TOPOLOGY_STRATEGY)
	private TopologyStrategy directTopologyStrategy;
	
	@Autowired
	@Qualifier(Constants.TOPIC_TOPOLOGY_STRATEGY)
	private TopologyStrategy topicTopologyStrategy;
	
	private Map<RoutingTopology, TopologyStrategy> map;
	
	@PostConstruct
	public void initFactory() {
		this.map = new HashMap<>();
		this.map.put(RoutingTopology.DIRECT, directTopologyStrategy);
		this.map.put(RoutingTopology.TOPIC, topicTopologyStrategy);
	}

	@Override
	public TopologyStrategy getStrategy(RoutingTopology topology) {
		return this.map.get(topology);
	}

}
