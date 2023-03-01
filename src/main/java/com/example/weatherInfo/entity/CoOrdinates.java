package com.example.weatherInfo.entity;

import java.util.Map;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CoOrdinates {
	@Id
	private String pincode;
	private String longitude;
	private String latitude;
	
	public CoOrdinates(Map<String, Object> data){
		this.pincode=(String) data.get("zip");
		this.latitude=Double.toString((Double) data.get("lat"));
		this.longitude=Double.toString((Double) data.get("lon"));
	}
}
