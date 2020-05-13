package com.allanrasmussen.bowlingopgave.beans;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class FrameTest {

	@Test
	void toStringReturnsRollScoresInsideBrackets() {
		assertEquals("[8,2]", new Frame(8,2).toString());
	}
}
