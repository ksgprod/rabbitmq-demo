package br.com.ksgprod.utils;

public enum RoutingTopology {

	DIRECT("rabbitmq.direct.exchange", "rabbitmq.direct.bind", "rabbitmq.direct.queue"), 
	TOPIC("rabbitmq.topic.exchange", "rabbitmq.topic.bind", "rabbitmq.topic.queue.first", "rabbitmq.topic.queue.second");
	
	private String exchange;
	private String bind;
	private String[] queues;
	
	private RoutingTopology(String exchange, String bind, String ... queues) {
		this.exchange = exchange;
		this.bind = bind;
		this.queues = queues;
	}
	
	public String getExchange() {
		return exchange;
	}
	
	public String getBind() {
		return bind;
	}
	
	public String[] getQueues() {
		return queues;
	}
	
}
