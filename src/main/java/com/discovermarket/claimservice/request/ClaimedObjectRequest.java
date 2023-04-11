package com.discovermarket.claimservice.request;

import java.io.Serializable;
import java.util.List;

public class ClaimedObjectRequest implements Serializable {

    private String objectIdentifier;

    private List<ClaimedObjectInstanceRequest> claimedObjectInstance;

    public String getObjectIdentifier() {
        return objectIdentifier;
    }

    public void setObjectIdentifier(String objectIdentifier) {
        this.objectIdentifier = objectIdentifier;
    }

    public List<ClaimedObjectInstanceRequest> getClaimedObjectInstance() {
        return claimedObjectInstance;
    }

    public void setClaimedObjectInstance(List<ClaimedObjectInstanceRequest> claimedObjectInstance) {
        this.claimedObjectInstance = claimedObjectInstance;
    }
}
