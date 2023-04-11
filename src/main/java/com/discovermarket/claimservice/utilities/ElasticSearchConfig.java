package com.discovermarket.claimservice.utilities;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component("esConfig")
@RefreshScope
public class ElasticSearchConfig {
    @Value("${elasticSearchIndexName}")
    private String indexName;

    public String getIndexName() {
        return indexName;
    }

    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }
}