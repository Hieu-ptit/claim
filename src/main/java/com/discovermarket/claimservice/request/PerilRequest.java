package com.discovermarket.claimservice.request;

import org.bson.types.ObjectId;

import java.util.List;

public class PerilRequest {

    private ObjectId perilIdentifier;

    private List<CauseRequest> cause;

    public ObjectId getPerilIdentifier() {
        return perilIdentifier;
    }

    public void setPerilIdentifier(ObjectId perilIdentifier) {
        this.perilIdentifier = perilIdentifier;
    }

    public List<CauseRequest> getCause() {
        return cause;
    }

    public void setCause(List<CauseRequest> cause) {
        this.cause = cause;
    }
}
