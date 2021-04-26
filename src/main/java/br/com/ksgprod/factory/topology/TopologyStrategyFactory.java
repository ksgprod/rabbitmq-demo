package br.com.ksgprod.factory.topology;

import br.com.ksgprod.strategy.TopologyStrategy;
import br.com.ksgprod.utils.RoutingTopology;

public interface TopologyStrategyFactory {
	
	public TopologyStrategy getStrategy(RoutingTopology topology);

}
