package com.discovermarket.claimservice.clients;

import com.discovermarket.claimservice.models.SendEmailResponseDTO;
import com.discovermarket.claimservice.request.NotificationSendRequestDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface NotificationClient {
    SendEmailResponseDTO sendEmail(NotificationSendRequestDTO dto) throws JsonProcessingException;
}
