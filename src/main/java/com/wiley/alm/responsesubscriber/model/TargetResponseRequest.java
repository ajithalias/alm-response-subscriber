package com.wiley.alm.responsesubscriber.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.springframework.stereotype.Component;

@Component
@XmlRootElement(name = "Fulfillment")
@XmlType(propOrder = { "header", "body" })
public class TargetResponseRequest {
	
	private HeaderTM header;
	private BodyTM body;
	public HeaderTM getHeader() {
		return header;
	}
	public void setHeader(HeaderTM header) {
		this.header = header;
	}
	public BodyTM getBody() {
		return body;
	}
	public void setBody(BodyTM body) {
		this.body = body;
	}
	
	
	
	

}
