package com.discovermarket.claimservice.entities;

import com.discovermarket.claimservice.entities.embedded.*;
import com.discovermarket.core.entities.MongoBaseEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import java.util.Date;
import java.util.List;

@Entity
@Document(collection = "claims")
public class Claim extends MongoBaseEntity {

    @Field("incident_identifier")
    private String incidentIdentifier;

    @Field("claim_number")
    private String claimNumber;

    @Field("claim_description")
    private String claimDescription;

    @Field("transaction_date")
    private Date transactionDate;

    @Field("claim_poc_email")
    private String claimPocEmail;

    @Field("claim_poc_phone")
    private String claimPocPhone;

    @Field("claim_poc_relationship_to_policyholder")
    private String claimPocRelationshipToPolicyholder;

    @Field("claim_poc_name")
    private String claimPocName;

    @Field("date_of_settlement")
    private Date dateOfSettlement;

    @Field("date_of_discovery")
    private Date dateOfDiscovery;

    @Field("date_of_fnol")
    private Date dateOfFnol;

    @Field("date_of_loss")
    private Date dateOfLoss;

    @Field("party_customer_identifier")
    private ObjectId partyCustomerIdentifier;

    @Field("contract_number")
    private String contractNumber;

    @Field("policy_number")
    private String policyNumber;

    @Field("line_of_business_identifier")
    private ObjectId lineOfBusinessIdentifier;

    @Field("loss_adjuster_party_service_provider_identifier")
    private String lossAdjusterPartyServiceProviderIdentifier;

    @Embedded
    @Field("claimed_object")
    private List<ClaimedObject> claimedObject;

    @Embedded
    @Field("claims_cover_benefit_check")
    private List<ClaimsCoverBenefitCheck> claimsCoverBenefitCheck;

    @Embedded
    @Field("claim_risk_relation")
    private List<ClaimRiskRelation> claimRiskRelation;

    @Embedded
    @Field("claim_questions")
    private List<ClaimQuestion> claimQuestions;

    @Embedded
    @Field("claim_status")
    private ClaimStatus claimStatus;

    public Claim() {
    }

    public Claim(String claimNumber, String claimDescription) {
        this.claimNumber = claimNumber;
        this.claimDescription = claimDescription;
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

    public String getIncidentIdentifier() {
        return incidentIdentifier;
    }

    public void setIncidentIdentifier(String incidentIdentifier) {
        this.incidentIdentifier = incidentIdentifier;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getClaimPocEmail() {
        return claimPocEmail;
    }

    public void setClaimPocEmail(String claimPocEmail) {
        this.claimPocEmail = claimPocEmail;
    }

    public String getClaimPocPhone() {
        return claimPocPhone;
    }

    public void setClaimPocPhone(String claimPocPhone) {
        this.claimPocPhone = claimPocPhone;
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

    public List<ClaimedObject> getClaimedObject() {
        return claimedObject;
    }

    public void setClaimedObject(List<ClaimedObject> claimedObject) {
        this.claimedObject = claimedObject;
    }

    public List<ClaimsCoverBenefitCheck> getClaimsCoverBenefitCheck() {
        return claimsCoverBenefitCheck;
    }

    public void setClaimsCoverBenefitCheck(List<ClaimsCoverBenefitCheck> claimsCoverBenefitCheck) {
        this.claimsCoverBenefitCheck = claimsCoverBenefitCheck;
    }

    public List<ClaimRiskRelation> getClaimRiskRelation() {
        return claimRiskRelation;
    }

    public void setClaimRiskRelation(List<ClaimRiskRelation> claimRiskRelation) {
        this.claimRiskRelation = claimRiskRelation;
    }

    public List<ClaimQuestion> getClaimQuestions() {
        return claimQuestions;
    }

    public void setClaimQuestions(List<ClaimQuestion> claimQuestions) {
        this.claimQuestions = claimQuestions;
    }

    public ClaimStatus getClaimStatus() {
        return claimStatus;
    }

    public void setClaimStatus(ClaimStatus claimStatus) {
        this.claimStatus = claimStatus;
    }
}
