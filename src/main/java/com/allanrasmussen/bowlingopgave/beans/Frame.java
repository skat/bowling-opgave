package com.allanrasmussen.bowlingopgave.beans;

import java.io.Serializable;

public class Frame implements Serializable {
	private static final long serialVersionUID = -2312031617873813635L;

	private int roll1;
	private int roll2;
	
	public Frame() {}
	
	public Frame(final int roll1, final int roll2) {
		this.roll1 = roll1;
		this.roll2 = roll2;
	}

	public int getRoll1() {
		return roll1;
	}

	public void setRoll1(int roll1) {
		this.roll1 = roll1;
	}

	public int getRoll2() {
		return roll2;
	}

	public void setRoll2(int roll2) {
		this.roll2 = roll2;
	}
	
	@Override
	public String toString() {
		return String.format("[%s,%s]", roll1, roll2);
	}
}
