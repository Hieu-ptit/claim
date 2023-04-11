package com.discovermarket.claimservice.entities.embedded;

import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.io.Serializable;
import java.util.List;
@Embeddable
public class ClaimRiskRelation implements Serializable {

    @Embedded
    @Field("peril")
    private List<Peril> peril;

    public List<Peril> getPeril() {
        return peril;
    }

    public void setPeril(List<Peril> peril) {
        this.peril = peril;
    }
}
