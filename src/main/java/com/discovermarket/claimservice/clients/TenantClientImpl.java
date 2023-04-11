package com.discovermarket.claimservice.clients;

import com.discovermarket.claimservice.models.Template;
import com.discovermarket.claimservice.models.TenantConfigurationResponse;
import com.discovermarket.claimservice.models.TenantResponse;
import com.discovermarket.core.ultilities.HttpService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class TenantClientImpl implements TenantClient {

    @Value("${tenant-service-url}")
    private String baseTenantServiceUrl;

    @Value("${endpoint-prefix}")
    private String endpointPrefix;

    private ObjectMapper objectMapper;

    @Autowired
    public TenantClientImpl(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public TenantResponse getTenantById(String id){
        try {
            String url = String.format("%s%s%s", this.baseTenantServiceUrl, this.endpointPrefix, "/tenants");
            JsonNode jsonNode = HttpService.getById(url, id);

            if (jsonNode == null) {
                return null;
            }

            return this.objectMapper.readValue(jsonNode.toPrettyString(), TenantResponse.class);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Template getTenantConfigurationTemplate(String id, String refCode, String type) {
        try {
            String url = String.format("%s%s/configurations/tenant/%s", this.baseTenantServiceUrl, this.endpointPrefix, id);
            JsonNode jsonNode = HttpService.get(url);

            if (jsonNode == null) {
                return null;
            }

            TenantConfigurationResponse tenantResponse = this.objectMapper.readValue(jsonNode.toPrettyString(), TenantConfigurationResponse.class);

            Template template = null;
            if (tenantResponse != null) {
                List<Template> templates = tenantResponse.getTemplates();
                if (templates != null) {
                    template = templates.stream().filter(t -> (refCode.equals(t.getRefCode()) && type.equals(t.getType()))).findAny().orElse(null);
                }
            }

            return template;
        } catch (Exception e) {
            return null;
        }
    }
}
