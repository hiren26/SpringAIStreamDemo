package com.example.SpringAIStreamDemo.functions;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

@Configuration
public class FunctionConfiguration {

	private final WeatherConfigProperties props;
	
	public FunctionConfiguration(WeatherConfigProperties props) {
		this.props = props;
	}
	
	@Description("Get the current weather conditions for the given city.")
	@Bean
	public Function<WeatherService.Request, WeatherService.Response> currentWeatherFunction() {
		return new WeatherService(props);
	}
}
