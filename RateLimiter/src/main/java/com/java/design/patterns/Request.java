package com.java.design.patterns;

import java.time.Instant;

public class Request {
	private Instant ts;
	private int count;

	public Request(Instant ts, int count) {
		this.ts = ts;
		this.count = count;
	}

	public Instant getTs() {
		return ts;
	}

	public int getCount() {
		return count;
	}
}
