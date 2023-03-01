package com.example.weatherInfo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.weatherInfo.service.WeatherService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class WeatherController {
	
	private WeatherService service;
	@GetMapping("/{pincode}")
	public ResponseEntity<?> getWeatherData(@PathVariable String pincode){
		return ResponseEntity.ok(service.getWeatherData(pincode));
	}
}
