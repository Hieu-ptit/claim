package com.discovermarket.claimservice.request;

import java.util.List;

public class ClaimRiskRelationRequest {

    private List<PerilRequest> peril;

    public List<PerilRequest> getPeril() {
        return peril;
    }

    public void setPeril(List<PerilRequest> peril) {
        this.peril = peril;
    }
}
