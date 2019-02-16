package com.wiley.alm.responsesubscriber.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang3.builder.ToStringBuilder;


@XmlType(propOrder = { "generatedBy", "generationDate" })
public class HeaderTM {

	private String generatedBy;
	private Date generationDate;

	public HeaderTM() {
	}

	public HeaderTM(String generatedBy, Date generationDate) {
		this.generatedBy = generatedBy;
		this.generationDate = generationDate;
	}

	@XmlElement(name = "GeneratedBy", required = true)
	public String getGeneratedBy() {
		return generatedBy;
	}

	public void setGeneratedBy(String generatedBy) {
		this.generatedBy = generatedBy;
	}

	@XmlElement(name = "GenerationDate", required = true)
	public Date getGenerationDate() {
		return generationDate;
	}

	public void setGenerationDate(Date generationDate) {
		this.generationDate = generationDate;
	}

	@Override
	public String toString() {
	   return ToStringBuilder.reflectionToString(this);
	}
	
}