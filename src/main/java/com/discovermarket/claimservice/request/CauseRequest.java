package com.discovermarket.claimservice.request;

import org.bson.types.ObjectId;

import java.util.List;

public class CauseRequest {

    private ObjectId causeIdentifier;

    private List<SubCauseRequest> subCause;

    public ObjectId getCauseIdentifier() {
        return causeIdentifier;
    }

    public void setCauseIdentifier(ObjectId causeIdentifier) {
        this.causeIdentifier = causeIdentifier;
    }

    public List<SubCauseRequest> getSubCause() {
        return subCause;
    }

    public void setSubCause(List<SubCauseRequest> subCause) {
        this.subCause = subCause;
    }
}
