package com.example.SpringAIStreamDemo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class CityController {

	private final ChatClient chatClient;
	private Logger logger = org.slf4j.LoggerFactory.getLogger(CityController.class);
	
	public CityController(ChatClient.Builder builder) {
		this.chatClient = builder
				.defaultSystem("You are a helpful AI Assistant answering questions about cities around the world.")
				.defaultFunctions("currentWeatherFunction").build();
	}
	@GetMapping("/cities")
	public String cities(@RequestParam(value="prompt") String message) {
		//SystemMessage systemMessage = new SystemMessage("You are helpful AI Assistant answering questions about cities around the world.");	
		//UserMessage userMessage = new UserMessage(message);
		//OpenAiChatOptions chatOptions = OpenAiChatOptions.builder().function("currentWeatherFunction").build();	
	
		//ChatResponse response =  chatClient.call(new Prompt(List.of(systemMessage ,userMessage),chatOptions));
		
		return chatClient.prompt().user(message).call().content();
	}
	
	
	@GetMapping("/testcheck")
	public String test() {
		return "Hello World";
	}
}
