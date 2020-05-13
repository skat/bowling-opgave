package com.allanrasmussen.bowlingopgave;

import java.util.ArrayList;
import java.util.List;

import com.allanrasmussen.bowlingopgave.beans.Frame;
import com.allanrasmussen.bowlingopgave.helpers.FrameHelper;

public class ScoresCalculator {
	private static final int MAX_NUMBER_OF_FRAMES = 10;

	public static List<Integer> calculateScores(List<Frame> frames) {
		List<Integer> points = new ArrayList<Integer>();
		int total = 0;
		while(frames.size() > 0 && points.size() < MAX_NUMBER_OF_FRAMES) {
			Frame frame = frames.remove(0);
			total += FrameHelper.sum(frame) + extraPoints(frame, frames);
			points.add(total);
		}
		return points;

	}
	
	private static int extraPoints(Frame frame, List<Frame> frames) {
		List<Integer> rolls = new ArrayList<>();
		if (frames.size() > 0) {
			if (FrameHelper.isStrike(frame)) {
				rolls = getNextRolls(frames, true);
			} else if (FrameHelper.isSpare(frame)) {
				rolls = getNextRolls(frames, false);
			}
		}
		return rolls.stream().reduce(0,  Integer::sum);
	}

	private static List<Integer> getNextRolls(List<Frame> frames, boolean isStrikeNotSpare) {
		List<Integer> rolls = new ArrayList<>();
		if (frames.size() > 0) {
			rolls.add(frames.get(0).getRoll1());
			if (isStrikeNotSpare) {
				if (!FrameHelper.isStrike(frames.get(0))) {
					rolls.add(frames.get(0).getRoll2());
				}
				if (rolls.size() < 2 && frames.size() > 1) {
					rolls.add(frames.get(1).getRoll1());
				}
			}
		}
		return rolls;
	}
}
