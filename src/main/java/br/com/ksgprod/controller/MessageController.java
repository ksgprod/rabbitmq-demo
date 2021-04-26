package br.com.ksgprod.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.ksgprod.controller.request.MessageRequest;
import br.com.ksgprod.service.MessageService;

@RestController
@RequestMapping("/api/message")
public class MessageController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MessageController.class);
	
	private MessageService service;;
	
	public MessageController(MessageService service) {
		this.service = service;
	}

	@GetMapping()
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void sendMessage(@RequestBody MessageRequest request) throws Exception {

		LOGGER.info("stage=init method=MessageController.sendMessage request={}", request);

		this.service.sendMessage(request);

		LOGGER.info("stage=end method=MessageController.sendMessage response=void");

	}

}
