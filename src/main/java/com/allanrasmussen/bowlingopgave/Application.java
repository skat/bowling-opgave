package com.allanrasmussen.bowlingopgave;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.allanrasmussen.bowlingopgave.beans.Points;
import com.allanrasmussen.bowlingopgave.restconsumers.PointsConsumer;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		PointsConsumer pc = new PointsConsumer();
		Scanner scanner = new Scanner(System.in);
		Points points;

		String input = "";
		System.out.println("Press ENTER to get next set of Points. Write \"quit\" to quit.");
		do {
			points = pc.getPoints();
			System.out.println(points);
			List<Integer> scores = ScoresCalculator.calculateScores(points.getFrames());
			pc.postPoints(points.getToken(), scores);
			System.out.print("> ");
			input = scanner.nextLine();
		} while (!input.equalsIgnoreCase("quit"));
		scanner.close();
		System.out.println("BYE!");
		System.exit(0);
	}

}
