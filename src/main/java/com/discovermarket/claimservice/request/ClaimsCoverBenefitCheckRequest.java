package com.discovermarket.claimservice.request;

public class ClaimsCoverBenefitCheckRequest {

    private String benefitTypeCode;

    private String productBenefitIdentifier;

    public String getBenefitTypeCode() {
        return benefitTypeCode;
    }

    public void setBenefitTypeCode(String benefitTypeCode) {
        this.benefitTypeCode = benefitTypeCode;
    }

    public String getProductBenefitIdentifier() {
        return productBenefitIdentifier;
    }

    public void setProductBenefitIdentifier(String productBenefitIdentifier) {
        this.productBenefitIdentifier = productBenefitIdentifier;
    }
}
