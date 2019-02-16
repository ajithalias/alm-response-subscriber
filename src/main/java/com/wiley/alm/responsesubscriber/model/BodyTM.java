package com.wiley.alm.responsesubscriber.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

public class BodyTM {


	private Result[] results;

	@XmlElementWrapper(name="Results")
	@XmlElement(name="Result")
	public Result[] getResults() {
		return results;
	}

	public void setResults(Result[] results) {
		this.results = results;
	}
	
	
	

	
	
}
