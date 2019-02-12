package com.wiley.alm.responsesubscriber.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

public class BodyTM {

	@JacksonXmlElementWrapper(useWrapping = false)
	private Result[] results;

	public Result[] getResults() {
		return results;
	}

	public void setResults(Result[] results) {
		this.results = results;
	}
	
}
