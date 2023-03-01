package com.example.weatherInfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.weatherInfo.entity.CoOrdinates;

public interface CoOrdinatesRepository extends JpaRepository<CoOrdinates, String>{
	
}
