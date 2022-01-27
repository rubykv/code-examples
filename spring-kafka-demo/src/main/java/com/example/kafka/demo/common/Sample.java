package com.example.kafka.demo.common;

public class Sample {
	private String oneString;
	
	public Sample(String oneString) {
		this.oneString = oneString;
	}

	public String getOneString() {
		return oneString;
	}

	public void setOneString(String oneString) {
		this.oneString = oneString;
	}
	
	@Override
	public String toString() {
		return "sample " + this.oneString + " ";
	}

}
