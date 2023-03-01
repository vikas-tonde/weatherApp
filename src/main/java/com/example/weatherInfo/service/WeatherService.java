package com.example.weatherInfo.service;

import java.util.Map;
import java.util.Optional;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.weatherInfo.entity.CoOrdinates;
import com.example.weatherInfo.repository.CoOrdinatesRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class WeatherService {
	private CoOrdinatesRepository repository;
	private Environment environment;
	
	public Map<?, ?> getWeatherData(String pincode) {
		String api=environment.getProperty("apikey");
		Optional<CoOrdinates> coOrdinate = repository.findById(pincode);
		CoOrdinates co;
		if (coOrdinate.isEmpty()) {
			WebClient client = WebClient.create();
			Map<String, Object> m = client.get().uri("http://api.openweathermap.org/geo/1.0/zip?zip="+pincode
					+ ",IN&appid="+api).retrieve().bodyToMono(Map.class).block();
			co = new CoOrdinates(m);
			repository.save(co);
		} else {
			co = coOrdinate.get();
		}
		
		WebClient client = WebClient.create();
		Map<?, ?> weatherData = client.get().uri(String.format(
				"https://api.openweathermap.org/data/2.5/weather?lat=%s&lon=%s&appid=%s",
				co.getLatitude(), co.getLongitude(),api)).retrieve().bodyToMono(Map.class).block();
		return weatherData;
	}
}
