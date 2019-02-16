package com.wiley.alm.responsesubscriber.model.response.faliure;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

public class BodyTMF {


	private ResultF[] results;

	@XmlElementWrapper(name="Results")
	@XmlElement(name="Result")
	public ResultF[] getResults() {
		return results;
	}

	public void setResults(ResultF[] results) {
		this.results = results;
	}
	
	
	

	
	
}
