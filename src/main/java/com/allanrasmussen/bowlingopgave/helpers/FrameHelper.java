package com.allanrasmussen.bowlingopgave.helpers;

import com.allanrasmussen.bowlingopgave.beans.Frame;

public class FrameHelper {
	public static Frame spare(int roll1) {
		return new Frame(roll1, 10 - roll1);
	}

	public static int sum(Frame frame) {
		return frame.getRoll1() + frame.getRoll2();
	}

	public static boolean isStrike(Frame frame) {
		return frame.getRoll1() == 10 && frame.getRoll2() == 0;
	}

	public static boolean isSpare(Frame frame) {
		return frame.getRoll2() > 0 && (frame.getRoll1() + frame.getRoll2() == 10);
	}
}
