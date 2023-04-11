package com.discovermarket.claimservice.clients;

import com.discovermarket.claimservice.models.LobResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
@RefreshScope
public class CommonClientImpl implements CommonClient {
    @Value("${common-service-url}")
    private String commonServiceUrl;

    @Value("${endpoint-prefix}")
    private String endpointPrefix;

    @Value("${authentication.api-key-name}")
    private String apiKeyName;

    @Value("${authentication.api-key-value}")
    private String apiKeyValue;

    private ObjectMapper objectMapper;

    public CommonClientImpl(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public Optional<LobResponse> getLobDetails(String lobId) {
        try {
            String fullUrl = String.format("%s%s/lobs/%s", this.commonServiceUrl, this.endpointPrefix, lobId);
            com.mashape.unirest.http.JsonNode json = Unirest.get(fullUrl).header(apiKeyName, apiKeyValue)
                    .header("content-type", "application/json").asJson().getBody();

            JSONObject jsonObject = json.getObject();

            if (jsonObject.has("data")) {
                return Optional.ofNullable(this.objectMapper.readValue(jsonObject.get("data").toString(), LobResponse.class));
            }
        } catch (IOException | UnirestException exception) {
            return Optional.empty();
        }
        return Optional.empty();
    }

}
