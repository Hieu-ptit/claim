package com.discovermarket.claimservice.models;

public class Template {

    private String name;

    private String type;

    private String refCode;

    private String fileId;

    public Template() {
        super();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setRefCode(String refCode) {
        this.refCode = refCode;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getRefCode() {
        return refCode;
    }

    public String getFileId() {
        return fileId;
    }

}
