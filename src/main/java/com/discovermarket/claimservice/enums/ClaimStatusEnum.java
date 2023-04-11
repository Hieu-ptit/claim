package com.discovermarket.claimservice.enums;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public enum ClaimStatusEnum {

    DRAFT("DRAFT"), ACTIVE("ACTIVE");

    private final String statusCode;

    ClaimStatusEnum(String statusCode) {
        this.statusCode = statusCode;
    }

    private static final Map<String, ClaimStatusEnum> lookup = new HashMap<String, ClaimStatusEnum>();

    static {
        for (ClaimStatusEnum d : ClaimStatusEnum.values()) {
            lookup.put(d.getCode(), d);
        }
    }

    public String getCode() {
        return statusCode;
    }

    public static ClaimStatusEnum of(String status) {
        return Arrays.stream(ClaimStatusEnum.values())
                .filter(claimStatusEnum -> claimStatusEnum.statusCode.equals(status))
                .findFirst()
                .orElseThrow(IllegalAccessError::new);
    }
}
