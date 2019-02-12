package com.wiley.alm.responsesubscriber.model;

public enum EventType {

    IP_ADDED("IP_ADDED", "addAuthenticationMethods"), 
    IP_MODIFIED("IP_MODIFIED", "modifyAuthenticationMethods"), 
    IP_DELETED("IP_DELETED", "deleteAuthenticationMethods"), 
    TPS_ADDED("TPS_ADDED", "addAuthenticationMethods"), 
    TPS_MODIFIED("TPS_MODIFIED", "modifyAuthenticationMethods"), 
    TPS_DELETED("TPS_DELETED", "deleteAuthenticationMethods"), 
    OPENURL_ADDED("OPENURL_ADDED", "addAuthenticationMethods"), 
    OPENURL_MODIFIED("OPENURL_MODIFIED", "modifyAuthenticationMethods"), 
    OPENURL_DELETED("OPENURL_DELETED", "deleteAuthenticationMethods"), 
    REGEIONALPROVISION_ADDED( "REGEIONALPROVISION_ADDED", "addAuthenticationMethods"), 
    REGEIONALPROVISION_MODIFIED("REGEIONALPROVISION_MODIFIED", "modifyAuthenticationMethods"), 
    REGEIONALPROVISION_DELETED("REGEIONALPROVISION_DELETED", "deleteAuthenticationMethods"), 
    SHIBBOLETH_ADDED("SHIBBOLETH_ADDED", "addAuthenticationMethods"), 
    SHIBBOLETH_MODIFIED("SHIBBOLETH_MODIFIED", "modifyAuthenticationMethods"), 
    SHIBBOLETH_DELETED("SHIBBOLETH_DELETED", "deleteAuthenticationMethods");

	private EventType(String accessMethod, String transactionType) {
		this.accessMethod = accessMethod;
		this.transactionType = transactionType;
	}

	private String accessMethod;
	private String transactionType;

	public String getAccessMethod() {
		return accessMethod;
	}

	public void setAccessMethods(String accessMethod) {
		this.accessMethod = accessMethod;
	}
    
    public String getTransactionType() {
        return transactionType;
    }
    
    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }
}
