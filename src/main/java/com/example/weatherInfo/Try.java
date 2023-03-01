package com.example.weatherInfo;

import java.util.Map;

import org.springframework.web.reactive.function.client.WebClient;

public class Try {

	public static void main(String[] args) {
		WebClient client=WebClient.create();
		Map m= client.get()
	    .uri("http://api.openweathermap.org/geo/1.0/zip?zip=411024,IN&appid=bcff0d34e790c4178135dc5e5c6b5be4")
	    .retrieve()
	    .bodyToMono(Map.class)
	    .block();
		
		System.out.println(m);
	}
	
}
