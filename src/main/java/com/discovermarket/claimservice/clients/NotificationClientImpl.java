package com.discovermarket.claimservice.clients;

import com.discovermarket.claimservice.models.SendEmailResponseDTO;
import com.discovermarket.claimservice.request.NotificationSendRequestDTO;
import com.discovermarket.core.ultilities.HttpService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

@Service
@RefreshScope
public class NotificationClientImpl implements NotificationClient {

    @Value("${notification-service-url}")
    private String baseTenantServiceUrl;

    @Value("${endpoint-prefix}")
    private String endpointPrefix;

    private final ObjectMapper objectMapper;

    @Autowired
    public NotificationClientImpl(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public SendEmailResponseDTO sendEmail(NotificationSendRequestDTO dto) throws JsonProcessingException {
        String fullUrl = String.format("%s%s/notification/email", this.endpointPrefix, this.baseTenantServiceUrl);
        JsonNode node = HttpService.post(fullUrl, dto);
        return this.objectMapper.readValue(node.toString(), SendEmailResponseDTO.class);
    }
}
