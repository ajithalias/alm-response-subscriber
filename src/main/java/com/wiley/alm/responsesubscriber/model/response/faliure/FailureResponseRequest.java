package com.wiley.alm.responsesubscriber.model.response.faliure;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Fulfillment")
@XmlType(propOrder = { "header", "body" })
public class FailureResponseRequest {

	private HeaderTM header;
	private BodyTMF body;

	@XmlElement(name = "Header", required = true)
	public HeaderTM getHeader() {
		return header;
	}

	public void setHeader(HeaderTM header) {
		this.header = header;
	}

	@XmlElement(name = "Body", required = true)
	public BodyTMF getBody() {
		return body;
	}

	public void setBody(BodyTMF body) {
		this.body = body;
	}

}
