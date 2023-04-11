package com.discovermarket.claimservice.models;

import java.util.ArrayList;
import java.util.List;

public class TenantConfigurationResponse {

    private String id;

    private String tenantId;


    private String emailId;


    private List<Template> templates = new ArrayList<Template>();

    public TenantConfigurationResponse() {
        super();
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public List<Template> getTemplates() {
        return templates;
    }

    public void setTemplates(List<Template> templates) {
        this.templates = templates;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
