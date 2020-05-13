package com.allanrasmussen.bowlingopgave;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.allanrasmussen.bowlingopgave.beans.Frame;

class ScoresCalculatorTest {
	List<Frame> frames = new ArrayList<Frame>();
	
	@Test
	void totalScoreForPerfectMatchIs300() {
		List<Frame> perfectScore = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			perfectScore.add(new Frame(10, 0));
		}
		perfectScore.add(new Frame(10, 10));
		List<Integer> points = ScoresCalculator.calculateScores(perfectScore);
		assertEquals(300, points.get(points.size() - 1));
	}
	
	@Test
	void totalScoreForPerfectTreakIn10framesButWithNoExtraRollsIs270() {
		List<Frame> perfectScore = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			perfectScore.add(new Frame(10, 0));
		}
		List<Integer> points = ScoresCalculator.calculateScores(perfectScore);
		assertEquals(270, points.get(points.size() - 1));
	}
	
	@Test
	void totalScoreForOneFrameWithNoHitsIsZero() {
		frames.add(new Frame(0, 0));
		List<Integer> points = ScoresCalculator.calculateScores(frames);
		assertEquals(0, points.get(points.size() - 1));
	}
	
	@Test
	void totalScoreInIncompleteGameWithASpareButEndingWithPinsUpIs21() {
		frames.add(new Frame(0, 0));
		frames.add(new Frame(3, 7));
		frames.add(new Frame(5, 1));
		List<Integer> points = ScoresCalculator.calculateScores(frames);
		assertEquals(21, points.get(points.size() - 1));
	}
	
	@Test
	void totalScoreInCompleteGameEndingWithASpareAndAnExtraRollIs90() {
		frames.add(new Frame(0, 0));
		frames.add(new Frame(3, 1));
		frames.add(new Frame(5, 1));
		frames.add(new Frame(7, 1));
		frames.add(new Frame(5, 2));
		frames.add(new Frame(3, 7));
		frames.add(new Frame(5, 1));
		frames.add(new Frame(3, 4));
		frames.add(new Frame(10, 0));
		frames.add(new Frame(5, 5));
		frames.add(new Frame(7, 0));
		List<Integer> points = ScoresCalculator.calculateScores(frames);
		assertEquals(90, points.get(points.size() - 1));
	}
}
