package com.wiley.alm.responsesubscriber.model.response.faliure;

import javax.xml.bind.annotation.XmlElement;

public class Error {

	private String errorType;
	private String errorText;
	
	@XmlElement(name = "ErrorType")
	public String getErrorType() {
		return errorType;
	}
	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}
	
	@XmlElement(name = "ErrorText")
	public String getErrorText() {
		return errorText;
	}
	public void setErrorText(String errorText) {
		this.errorText = errorText;
	}
	
	
	
}
