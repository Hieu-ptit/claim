package com.discovermarket.claimservice.entities.embedded;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Embeddable;
import java.io.Serializable;
@Embeddable
public class SubCause implements Serializable {

    @Field("subcause_identifier")
    private ObjectId subCauseIdentifier;

    public ObjectId getSubCauseIdentifier() {
        return subCauseIdentifier;
    }

    public void setSubCauseIdentifier(ObjectId subCauseIdentifier) {
        this.subCauseIdentifier = subCauseIdentifier;
    }
}
