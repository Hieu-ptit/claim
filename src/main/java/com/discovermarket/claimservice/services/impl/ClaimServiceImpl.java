package com.discovermarket.claimservice.services.impl;

import com.discovermarket.claimservice.clients.CommonClient;
import com.discovermarket.claimservice.clients.NotificationClient;
import com.discovermarket.claimservice.clients.TenantClient;
import com.discovermarket.claimservice.entities.Claim;
import com.discovermarket.claimservice.entities.embedded.ClaimQuestion;
import com.discovermarket.claimservice.entities.embedded.ClaimStatus;
import com.discovermarket.claimservice.enums.ClaimStatusEnum;
import com.discovermarket.claimservice.exception.ClaimNotFoundException;
import com.discovermarket.claimservice.exception.LobNotFoundException;
import com.discovermarket.claimservice.models.*;
import com.discovermarket.claimservice.repositories.ClaimRepository;
import com.discovermarket.claimservice.request.ClaimRequest;
import com.discovermarket.claimservice.request.CreateClaimRequest;
import com.discovermarket.claimservice.request.NotificationSendRequestDTO;
import com.discovermarket.claimservice.services.ClaimService;
import com.discovermarket.claimservice.utilities.ErrorCode;
import com.discovermarket.claimservice.utilities.MessageConstants;
import com.discovermarket.claimservice.utilities.PdfGenaratorUtil;
import com.discovermarket.core.models.ApiResponse;
import com.discovermarket.core.models.SuccessApiResponse;
import org.bson.types.ObjectId;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ClaimServiceImpl implements ClaimService {

    private final ClaimRepository claimRepository;

    private final ModelMapper modelMapper;

    private final CommonClient commonClient;

    private final NotificationClient notificationClient;

    private final TenantClient tenantClient;


    @Autowired
    public ClaimServiceImpl(ClaimRepository claimRepository, ModelMapper modelMapper, CommonClient commonClient, NotificationClient notificationClient, TenantClient tenantClient, PdfGenaratorUtil pdfGenaratorUtil) {
        this.claimRepository = claimRepository;
        this.modelMapper = modelMapper;
        this.commonClient = commonClient;
        this.notificationClient = notificationClient;
        this.tenantClient = tenantClient;
    }

    @Override
    public List<AutoSaveQuestionDTO> getAnswerByClaim(String claimId) {

        ObjectId idClaim = new ObjectId(claimId);
        //get claim by id
        Claim claim = claimRepository.findById(idClaim).orElseThrow(() -> new ClaimNotFoundException(ErrorCode.CLAIM_NOT_FOUND));
        List<ClaimQuestion> claimQuestions = claim.getClaimQuestions() != null ? claim.getClaimQuestions() : new ArrayList<>();
        return claimQuestions.stream()
                .map(claimQuestion -> modelMapper.map(claimQuestion, AutoSaveQuestionDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public CreateClaimResponseDTO createClaim(CreateClaimRequest request) {
        Claim claim = modelMapper.map(request, Claim.class);
        // Validate lobId
        commonClient.getLobDetails(request.getLineOfBusinessIdentifier().toHexString()).orElseThrow(() -> new LobNotFoundException(ErrorCode.LOB_NOT_FOUND));

        ClaimStatus claimStatus = new ClaimStatus();
        claimStatus.setStatusCode(ClaimStatusEnum.DRAFT.getCode());
        claimStatus.setStatusDescription(ClaimStatusEnum.DRAFT.toString());
        claim.setClaimStatus(claimStatus);
        claim = claimRepository.save(claim);

        CreateClaimResponseDTO claimDTO = modelMapper.map(claim, CreateClaimResponseDTO.class);
        claimDTO.setId(claim.getId().toHexString());

        return claimDTO;
    }

    @Override
    public List<AutoSaveQuestionDTO> updateClaim(String id, List<ClaimRequest> request) {
        ObjectId idClaim = new ObjectId(id);
        List<ClaimQuestion> claimQuestions = request.stream().map(it -> modelMapper.map(it, ClaimQuestion.class)).collect(Collectors.toList());
        if (claimRepository.updateClaimToEntity(idClaim, claimQuestions) < 1) {
            throw new ClaimNotFoundException(ErrorCode.CLAIM_NOT_FOUND);
        }
        return request.stream().map(it -> modelMapper.map(it, AutoSaveQuestionDTO.class)).collect(Collectors.toList());
    }

    @Override
    public ApiResponse sendEmail(NotificationSendRequestDTO request) throws IOException {
        TenantResponse tenantResponse = tenantClient.getTenantById(request.getTenantId());
        Template template = tenantClient.getTenantConfigurationTemplate(tenantResponse.getId(), request.getCode(), "email");
        SendEmailResponseDTO sendEmailResponseDTO = notificationClient.sendEmail(mapToNotificationSendRequest(getDefParams(tenantResponse, template), request));
        return new SuccessApiResponse(HttpStatus.OK, sendEmailResponseDTO);
    }

    private Map<String, String> getDefParams(TenantResponse tenant, Template emailTemplate) {
        //######## Prepare def. params
        Map<String, String> defParams = new HashMap<>();
        defParams.put(MessageConstants.NOTIFICATION_TENANT_LOGO, tenant.getLogo());
        defParams.put(MessageConstants.NOTIFICATION_EMAIL_TEMPLATE, emailTemplate.getFileId());
        return defParams;
    }

    private NotificationSendRequestDTO mapToNotificationSendRequest(Map<String, String> param, NotificationSendRequestDTO request) {
        request.setParams(param);
        request.setToEmail("hahtruong@kms-technology.com");
        request.setSubject("topic sen email");
        return request;
    }
}
