package com.example.SpringAIStreamDemo.functions;

import java.util.function.Function;

import org.slf4j.Logger;
import org.springframework.web.client.RestClient;


	/*
	Weather API :	https://www.weatherapi.com/api-explorer.aspx
	*/
public class WeatherService implements Function<WeatherService.Request, WeatherService.Response> {

	private final RestClient restClient;
	private final WeatherConfigProperties weatherProps;
	private final Logger logger = org.slf4j.LoggerFactory.getLogger(WeatherService.class);
	
	public WeatherService(WeatherConfigProperties weatherProps) {
		this.weatherProps = weatherProps;
		logger.info("Weather API Key: {}", weatherProps.apiKey());
		logger.info("Weather API URL: {}", weatherProps.apiUrl());
		this.restClient = RestClient.create(weatherProps.apiUrl());
	}
	 @Override
	public Response apply(WeatherService.Request weatherRequest) {
		logger.info("Weather request: {}", weatherRequest);
		Response response = restClient.get().uri("/current.json?key={apiKey}&q={city}", weatherProps.apiKey(), weatherRequest.city())
				.retrieve()
				.body(Response.class);
		logger.info("Weather response: {}", response);		
		return response;
	}
	
	public record Request(String city) {}
	public record Response(Location location,Current current) {}
	public record Location(String name, String region, String country, Long lat, Long lon) {}
	public record Current(String temp_c, Condition condition, String wind_kphz, String humidity) {}
    public record Condition(String text){}
	

}
