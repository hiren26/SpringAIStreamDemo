package com.example.SpringAIStreamDemo.controller;

import javax.sound.midi.SysexMessage;

import org.slf4j.Logger;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RequestMapping("/api")
@RestController
@CrossOrigin
public class ChatController {

	private final ChatClient chatClient;
	private Logger logger = org.slf4j.LoggerFactory.getLogger(ChatController.class);
	
	public ChatController(ChatClient.Builder chatClient) {
		this.chatClient = chatClient.build();
		
	}
	@PostMapping("/chat")
	public String chat(@RequestParam(value="prompt") String message) {
		logger.info("Chat prompt: {}", message);
		return chatClient.prompt().user(message).call().content();
				
	}
	@GetMapping("/stream")
	public Flux<String> stream(@RequestParam(value="prompt") String message) {
		logger.info("Chat prompt for stream: {}", message);
		return chatClient.prompt().user(message).stream().content();
				
	}
		
	
	@GetMapping("/test")
	public String test() {
		return "Hello World";
	}
	

}
