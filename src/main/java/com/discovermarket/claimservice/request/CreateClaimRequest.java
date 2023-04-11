package com.discovermarket.claimservice.request;

import org.bson.types.ObjectId;

public class CreateClaimRequest {

    private ObjectId lineOfBusinessIdentifier;

    public ObjectId getLineOfBusinessIdentifier() {
        return lineOfBusinessIdentifier;
    }

    public void setLineOfBusinessIdentifier(ObjectId lineOfBusinessIdentifier) {
        this.lineOfBusinessIdentifier = lineOfBusinessIdentifier;
    }
}
