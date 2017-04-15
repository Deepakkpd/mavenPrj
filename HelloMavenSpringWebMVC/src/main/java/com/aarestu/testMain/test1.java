package com.aarestu.testMain;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity(
		        "http://mymovieapi.com/?type=json&id=tt0098904&release=full&plot=full",
		        String.class);

		System.out.println(response);
	}
//
	//http://services.groupkt.com/state/get/IND/UP
}
