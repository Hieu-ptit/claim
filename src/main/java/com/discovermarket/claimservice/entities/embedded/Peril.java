package com.discovermarket.claimservice.entities.embedded;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.io.Serializable;
import java.util.List;
@Embeddable
public class Peril implements Serializable {

    @Field("peril_identifier")
    private ObjectId perilIdentifier;

    @Embedded
    @Field("cause")
    private List<Cause> cause;

    public ObjectId getPerilIdentifier() {
        return perilIdentifier;
    }


    public void setPerilIdentifier(ObjectId perilIdentifier) {
        this.perilIdentifier = perilIdentifier;
    }

    public List<Cause> getCause() {
        return cause;
    }

    public void setCause(List<Cause> cause) {
        this.cause = cause;
    }
}
