package br.com.ksgprod.controller.request;

import java.io.Serializable;

import com.google.gson.Gson;

import br.com.ksgprod.utils.RoutingTopology;

public class MessageRequest implements Serializable {

	private static final long serialVersionUID = 1130986476381808679L;
	
	private String message;
	
	private RoutingTopology topology;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public RoutingTopology getTopology() {
		return topology;
	}

	public void setTopology(RoutingTopology topology) {
		this.topology = topology;
	}
	
	@Override
	public String toString() {
		return new Gson().toJson(this);
	}
	
}
