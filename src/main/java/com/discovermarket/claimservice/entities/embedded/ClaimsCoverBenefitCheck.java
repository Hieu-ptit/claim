package com.discovermarket.claimservice.entities.embedded;

import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Embeddable;
import java.io.Serializable;
@Embeddable
public class ClaimsCoverBenefitCheck implements Serializable {

    @Field("benefit_type_code")
    private String benefitTypeCode;

    @Field("product_benefit_identifier")
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
