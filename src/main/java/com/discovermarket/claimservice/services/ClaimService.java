package com.discovermarket.claimservice.services;

import com.discovermarket.claimservice.models.AutoSaveQuestionDTO;
import com.discovermarket.claimservice.models.CreateClaimResponseDTO;
import com.discovermarket.claimservice.request.ClaimRequest;
import com.discovermarket.claimservice.request.CreateClaimRequest;
import com.discovermarket.claimservice.request.NotificationSendRequestDTO;
import com.discovermarket.core.models.ApiResponse;

import java.io.IOException;
import java.util.List;

public interface ClaimService {

    List<AutoSaveQuestionDTO> getAnswerByClaim(String claimId);

    CreateClaimResponseDTO createClaim(CreateClaimRequest request);

    List<AutoSaveQuestionDTO> updateClaim(String id, List<ClaimRequest> request) throws Exception;

    ApiResponse sendEmail(NotificationSendRequestDTO request) throws IOException;
}
