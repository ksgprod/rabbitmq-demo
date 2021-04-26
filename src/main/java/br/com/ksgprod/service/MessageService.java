package br.com.ksgprod.service;

import br.com.ksgprod.controller.request.MessageRequest;

public interface MessageService {
	
	public void sendMessage(MessageRequest request);

}
