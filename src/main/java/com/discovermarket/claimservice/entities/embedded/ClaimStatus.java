package com.discovermarket.claimservice.entities.embedded;

import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;
@Embeddable
public class ClaimStatus implements Serializable {

    @Field("status_code")
    private String statusCode;

    @Field("status_description")
    private String statusDescription;

    @Field("status_effective_date")
    private Date statusEffectiveDate;

    @Field("status_remarks")
    private String statusRemarks;

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    public Date getStatusEffectiveDate() {
        return statusEffectiveDate;
    }

    public void setStatusEffectiveDate(Date statusEffectiveDate) {
        this.statusEffectiveDate = statusEffectiveDate;
    }

    public String getStatusRemarks() {
        return statusRemarks;
    }

    public void setStatusRemarks(String statusRemarks) {
        this.statusRemarks = statusRemarks;
    }
}
