package br.com.ksgprod.jms.payload;

import java.io.Serializable;

import com.google.gson.Gson;

import br.com.ksgprod.controller.request.MessageRequest;

public class MessagePayload implements Serializable {
	
	private static final long serialVersionUID = -7224013197210286639L;
	
	private String title;
	
	private String message;

	public String getTitle() {
		return title;
	}

	public String getMessage() {
		return message;
	}

	public MessagePayload title(String title) {
		this.title = title;
		return this;
	}
	
	public MessagePayload message(String message) {
		this.message = message;
		return this;
	}
	
	public static MessagePayload builder(MessageRequest request) {
		String title = "Message sent by " + request.getTopology() + " topology.";
		return new MessagePayload().title(title).message(request.getMessage());
	}
	
	@Override
	public String toString() {
		return new Gson().toJson(this);
	}
	
}
