package com.discovermarket.claimservice.configs;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.discovermarket.planindexerservice.entities")
@RefreshScope
public class ElasticSearchConfig {

    @Value("${elasticSearchHost}")
    private String elasticSearchHost;

    @Value("${elasticSearchUserName}")
    private String elasticSearchUserName;

    @Value("${elasticSearchPassword}")
    private String elasticSearchPassword;

    @Bean
    public RestHighLevelClient client() {
        ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo(elasticSearchHost)
                .usingSsl()
                .withBasicAuth(elasticSearchUserName, elasticSearchPassword)
                .withConnectTimeout(120000)
                .withSocketTimeout(120000)
                .build();
        return RestClients.create(clientConfiguration).rest();
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() {
        return new ElasticsearchRestTemplate(client());
    }
}
