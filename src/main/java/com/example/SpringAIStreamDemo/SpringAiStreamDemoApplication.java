package com.example.SpringAIStreamDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.example.SpringAIStreamDemo.functions.WeatherConfigProperties;

@EnableConfigurationProperties(WeatherConfigProperties.class)
@SpringBootApplication
public class SpringAiStreamDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAiStreamDemoApplication.class, args);
	}

}
