package com.allanrasmussen.bowlingopgave.restconsumers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.json.simple.JSONObject;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.allanrasmussen.bowlingopgave.beans.Frame;
import com.allanrasmussen.bowlingopgave.beans.Points;

public class PointsConsumer {
	private final String uri = "http://13.74.31.101/api/points";

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	public Points getPoints() {
		Points points = new Points();
		RestTemplate restTemplate = new RestTemplate();
		JSONObject response = restTemplate.getForObject(uri, JSONObject.class);
		points.setToken(response.get("token").toString());
		points.setPoints(convertPointsStringToFrames(response.get("points").toString()));
		return points;
	}

	@SuppressWarnings("unchecked")
	public boolean postPoints(String token, List<Integer> scores) {
		RestTemplate restTemplate = new RestTemplate();

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("token", token);
		jsonObject.put("points", scores);
		System.out.println(restTemplate.postForObject(uri, jsonObject, String.class));
		return true;
	}

	public void sendPoints(Points points) {
		RestTemplate restTemplate = new RestTemplate();
		System.out.println(restTemplate.postForObject(uri, points, String.class));
	}

	private List<Frame> convertPointsStringToFrames(String pointsString) {
		return Arrays.asList(pointsString.substring(0, pointsString.length() - 1).substring(1).split("], ")).stream()
				.map(s -> {
					String[] frameAsString = s.replace("[", "").replace("]", "").split(",");
					return new Frame(Integer.parseInt(frameAsString[0]), Integer.parseInt(frameAsString[1].trim()));
				}).collect(Collectors.toList());
	}
}
