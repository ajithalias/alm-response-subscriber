package com.wiley.alm.responsesubscriber.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

//@XmlType(propOrder = { "operationType", "primaryObjectID,operationResult,sequenceNumber" })
public class Result {

	private String operationType;
	private String primaryObjectID;
	private String operationResult;
	private String sequenceNumber;

	@XmlElement(name = "OperationType")
	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	@XmlElement(name = "PrimaryObjectID")
	public String getPrimaryObjectID() {
		return primaryObjectID;
	}

	public void setPrimaryObjectID(String primaryObjectID) {
		this.primaryObjectID = primaryObjectID;
	}

	@XmlElement(name = "OperationResult")
	public String getOperationResult() {
		return operationResult;
	}

	public void setOperationResult(String operationResult) {
		this.operationResult = operationResult;
	}

	@XmlElement(name = "SequenceNumber")
	public String getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(String sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

}
