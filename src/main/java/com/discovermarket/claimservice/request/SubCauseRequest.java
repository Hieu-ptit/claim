package com.discovermarket.claimservice.request;

import org.bson.types.ObjectId;

public class SubCauseRequest {

    private ObjectId subCauseIdentifier;

    public ObjectId getSubCauseIdentifier() {
        return subCauseIdentifier;
    }

    public void setSubCauseIdentifier(ObjectId subCauseIdentifier) {
        this.subCauseIdentifier = subCauseIdentifier;
    }
}
