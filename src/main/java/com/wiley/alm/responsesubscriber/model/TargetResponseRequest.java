package com.wiley.alm.responsesubscriber.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Fulfillment")
@XmlType(propOrder = { "header", "body" })
public class TargetResponseRequest {

	private HeaderTM header;
	private BodyTM body;

	@XmlElement(name = "Header", required = true)
	public HeaderTM getHeader() {
		return header;
	}

	public void setHeader(HeaderTM header) {
		this.header = header;
	}

	@XmlElement(name = "Body", required = true)
	public BodyTM getBody() {
		return body;
	}

	public void setBody(BodyTM body) {
		this.body = body;
	}

}
