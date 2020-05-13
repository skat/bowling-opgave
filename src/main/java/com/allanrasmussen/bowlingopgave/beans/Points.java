package com.allanrasmussen.bowlingopgave.beans;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class Points implements Serializable {
	private static final long serialVersionUID = 4521849028801717061L;

	private List<Frame> frames;
	private String token;

	public List<Frame> getFrames() {
		return frames;
	}
	public void setPoints(List<Frame> points) {
		this.frames = points;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return new StringBuilder("{")
				.append("frames=[")
				.append(frames.stream().map(frame -> frame.toString()).collect(Collectors.joining(",")))
				.append("], ")
				.append("token='")
				.append(token)
				.append("'")
				.append("}")
				.toString();
	}
}
