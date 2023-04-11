package com.discovermarket.claimservice.entities.embedded;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.io.Serializable;
import java.util.List;

@Embeddable
public class Cause implements Serializable {

    @Field("cause_identifier")
    private ObjectId causeIdentifier;

    @Embedded
    @Field("subcause")
    private List<SubCause> subCause;

    public ObjectId getCauseIdentifier() {
        return causeIdentifier;
    }

    public void setCauseIdentifier(ObjectId causeIdentifier) {
        this.causeIdentifier = causeIdentifier;
    }

    public List<SubCause> getSubCause() {
        return subCause;
    }

    public void setSubCause(List<SubCause> subCause) {
        this.subCause = subCause;
    }
}
