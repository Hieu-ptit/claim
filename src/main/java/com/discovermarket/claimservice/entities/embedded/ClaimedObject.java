package com.discovermarket.claimservice.entities.embedded;

import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.io.Serializable;
import java.util.List;
@Embeddable
public class ClaimedObject implements Serializable {

    @Field("object_identifier")
    private String objectIdentifier;

    @Embedded
    @Field("claimed_object")
    private List<ClaimedObjectInstance> claimedObjectInstance;

    public String getObjectIdentifier() {
        return objectIdentifier;
    }

    public void setObjectIdentifier(String objectIdentifier) {
        this.objectIdentifier = objectIdentifier;
    }

    public List<ClaimedObjectInstance> getClaimedObjectInstance() {
        return claimedObjectInstance;
    }

    public void setClaimedObjectInstance(List<ClaimedObjectInstance> claimedObjectInstance) {
        this.claimedObjectInstance = claimedObjectInstance;
    }
}
