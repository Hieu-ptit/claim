package com.discovermarket.claimservice.entities.embedded;

import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Embeddable;
import java.io.Serializable;
@Embeddable
public class ClaimedObjectInstance implements Serializable {

    @Field("insured_object_instance_identifier")
    private String insuredObjectInstanceIdentifier;

    public String getInsuredObjectInstanceIdentifier() {
        return insuredObjectInstanceIdentifier;
    }

    public void setInsuredObjectInstanceIdentifier(String insuredObjectInstanceIdentifier) {
        this.insuredObjectInstanceIdentifier = insuredObjectInstanceIdentifier;
    }
}
