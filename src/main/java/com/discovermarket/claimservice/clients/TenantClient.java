package com.discovermarket.claimservice.clients;

import com.discovermarket.claimservice.models.Template;
import com.discovermarket.claimservice.models.TenantResponse;

import java.io.IOException;

public interface TenantClient {

    TenantResponse getTenantById(String id) throws IOException;

    Template getTenantConfigurationTemplate(String id, String refCode, String type);
}
