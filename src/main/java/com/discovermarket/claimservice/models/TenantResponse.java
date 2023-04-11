package com.discovermarket.claimservice.models;


import com.discovermarket.core.entities.PartyStatus;

public class TenantResponse {
	private String Code;	
	
	private String logo;

	private String name;

	private String operatingCountryIsoCode;

	private String isoCurrencyCode;

	private String isoLanguageCode;

	private String loggedInRedirectUrl;

	private String unauthorizedRedirectUrl;

	private String forbiddenRedirectUrl;

	private String loginMethodId;

	private PartyStatus partyStatus;
	
	private String lastSyncTs;

	private String id;
	
	public String getLastSyncTs() {
		return lastSyncTs;
	}

	public void setLastSyncTs(String lastSyncTs) {
		this.lastSyncTs = lastSyncTs;
	}

	public TenantResponse() {
		super();
	}

	public String getCode() {
		return Code;
	}

	public void setCode(String code) {
		Code = code;
	}
	
	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOperatingCountryIsoCode() {
		return operatingCountryIsoCode;
	}

	public void setOperatingCountryIsoCode(String operatingCountryIsoCode) {
		this.operatingCountryIsoCode = operatingCountryIsoCode;
	}

	public String getIsoCurrencyCode() {
		return isoCurrencyCode;
	}

	public void setIsoCurrencyCode(String isoCurrencyCode) {
		this.isoCurrencyCode = isoCurrencyCode;
	}

	public String getIsoLanguageCode() {
		return isoLanguageCode;
	}

	public void setIsoLanguageCode(String isoLanguageCode) {
		this.isoLanguageCode = isoLanguageCode;
	}

	public String getLoggedInRedirectUrl() {
		return loggedInRedirectUrl;
	}

	public void setLoggedInRedirectUrl(String loggedInRedirectUrl) {
		this.loggedInRedirectUrl = loggedInRedirectUrl;
	}

	public String getUnauthorizedRedirectUrl() {
		return unauthorizedRedirectUrl;
	}

	public void setUnauthorizedRedirectUrl(String unauthorizedRedirectUrl) {
		this.unauthorizedRedirectUrl = unauthorizedRedirectUrl;
	}

	public String getForbiddenRedirectUrl() {
		return forbiddenRedirectUrl;
	}

	public void setForbiddenRedirectUrl(String forbiddenRedirectUrl) {
		this.forbiddenRedirectUrl = forbiddenRedirectUrl;
	}

	public String getLoginMethodId() {
		return loginMethodId;
	}

	public void setLoginMethodId(String loginMethodId) {
		this.loginMethodId = loginMethodId;
	}

	public PartyStatus getPartyStatus() {
		return partyStatus;
	}

	public void setPartyStatus(PartyStatus partyStatus) {
		this.partyStatus = partyStatus;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
