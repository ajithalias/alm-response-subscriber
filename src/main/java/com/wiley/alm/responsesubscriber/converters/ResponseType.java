package com.wiley.alm.responsesubscriber.converters;

public enum ResponseType {

	SUCCESS("SUCCESS"), FAILED("FAILED");

	private String type;

	private ResponseType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	

}
