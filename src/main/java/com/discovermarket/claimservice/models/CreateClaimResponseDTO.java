package com.discovermarket.claimservice.models;

import com.discovermarket.claimservice.entities.embedded.ClaimStatus;
import com.discovermarket.claimservice.enums.ClaimStatusEnum;
import com.discovermarket.claimservice.request.ClaimRequest;
import com.discovermarket.claimservice.request.ClaimRiskRelationRequest;
import com.discovermarket.claimservice.request.ClaimedObjectRequest;
import com.discovermarket.claimservice.request.ClaimsCoverBenefitCheckRequest;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.bson.types.ObjectId;

import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateClaimResponseDTO {

    private String id;

    private String incidentIdentifier;

    private String claimNumber;

    private String claimDescription;

    private String claimPocEmail;

    private String claimPocRelationshipToPolicyholder;

    private String claimPocName;

    private Date dateOfSettlement;

    private Date dateOfDiscovery;

    private Date dateOfFnol;

    private Date dateOfLoss;

    private ObjectId partyCustomerIdentifier;

    private String contractNumber;

    private String policyNumber;

    private ObjectId lineOfBusinessIdentifier;

    private String lossAdjusterPartyServiceProviderIdentifier;

    private List<ClaimedObjectRequest> claimedObject;

    private List<ClaimsCoverBenefitCheckRequest> claimsCoverBenefitCheck;

    private List<ClaimRiskRelationRequest> claimRiskRelation;

    private ClaimStatus status;

    private List<ClaimRequest> claimRequests;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIncidentIdentifier() {
        return incidentIdentifier;
    }

    public void setIncidentIdentifier(String incidentIdentifier) {
        this.incidentIdentifier = incidentIdentifier;
    }

    public String getClaimNumber() {
        return claimNumber;
    }

    public void setClaimNumber(String claimNumber) {
        this.claimNumber = claimNumber;
    }

    public String getClaimDescription() {
        return claimDescription;
    }

    public void setClaimDescription(String claimDescription) {
        this.claimDescription = claimDescription;
    }

    public String getClaimPocEmail() {
        return claimPocEmail;
    }

    public void setClaimPocEmail(String claimPocEmail) {
        this.claimPocEmail = claimPocEmail;
    }

    public List<ClaimRequest> getClaimRequests() {
        return claimRequests;
    }

    public void setClaimRequests(List<ClaimRequest> claimRequests) {
        this.claimRequests = claimRequests;
    }

    public ClaimStatus getStatus() {
        return status;
    }

    public void setStatus(ClaimStatus status) {
        this.status = status;
    }

    public String getClaimPocRelationshipToPolicyholder() {
        return claimPocRelationshipToPolicyholder;
    }

    public void setClaimPocRelationshipToPolicyholder(String claimPocRelationshipToPolicyholder) {
        this.claimPocRelationshipToPolicyholder = claimPocRelationshipToPolicyholder;
    }

    public String getClaimPocName() {
        return claimPocName;
    }

    public void setClaimPocName(String claimPocName) {
        this.claimPocName = claimPocName;
    }

    public Date getDateOfSettlement() {
        return dateOfSettlement;
    }

    public void setDateOfSettlement(Date dateOfSettlement) {
        this.dateOfSettlement = dateOfSettlement;
    }

    public Date getDateOfDiscovery() {
        return dateOfDiscovery;
    }

    public void setDateOfDiscovery(Date dateOfDiscovery) {
        this.dateOfDiscovery = dateOfDiscovery;
    }

    public Date getDateOfFnol() {
        return dateOfFnol;
    }

    public void setDateOfFnol(Date dateOfFnol) {
        this.dateOfFnol = dateOfFnol;
    }

    public Date getDateOfLoss() {
        return dateOfLoss;
    }

    public void setDateOfLoss(Date dateOfLoss) {
        this.dateOfLoss = dateOfLoss;
    }

    public ObjectId getPartyCustomerIdentifier() {
        return partyCustomerIdentifier;
    }

    public void setPartyCustomerIdentifier(ObjectId partyCustomerIdentifier) {
        this.partyCustomerIdentifier = partyCustomerIdentifier;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public ObjectId getLineOfBusinessIdentifier() {
        return lineOfBusinessIdentifier;
    }

    public void setLineOfBusinessIdentifier(ObjectId lineOfBusinessIdentifier) {
        this.lineOfBusinessIdentifier = lineOfBusinessIdentifier;
    }

    public String getLossAdjusterPartyServiceProviderIdentifier() {
        return lossAdjusterPartyServiceProviderIdentifier;
    }

    public void setLossAdjusterPartyServiceProviderIdentifier(String lossAdjusterPartyServiceProviderIdentifier) {
        this.lossAdjusterPartyServiceProviderIdentifier = lossAdjusterPartyServiceProviderIdentifier;
    }

    public List<ClaimedObjectRequest> getClaimedObject() {
        return claimedObject;
    }

    public void setClaimedObject(List<ClaimedObjectRequest> claimedObject) {
        this.claimedObject = claimedObject;
    }

    public List<ClaimsCoverBenefitCheckRequest> getClaimsCoverBenefitCheck() {
        return claimsCoverBenefitCheck;
    }

    public void setClaimsCoverBenefitCheck(List<ClaimsCoverBenefitCheckRequest> claimsCoverBenefitCheck) {
        this.claimsCoverBenefitCheck = claimsCoverBenefitCheck;
    }

    public List<ClaimRiskRelationRequest> getClaimRiskRelation() {
        return claimRiskRelation;
    }

    public void setClaimRiskRelation(List<ClaimRiskRelationRequest> claimRiskRelation) {
        this.claimRiskRelation = claimRiskRelation;
    }
}
