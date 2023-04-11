package com.discovermarket.claimservice.controller;

import com.discovermarket.claimservice.models.AutoSaveQuestionDTO;
import com.discovermarket.claimservice.models.CreateClaimResponseDTO;
import com.discovermarket.claimservice.request.ClaimRequest;
import com.discovermarket.claimservice.request.CreateClaimRequest;
import com.discovermarket.claimservice.request.NotificationSendRequestDTO;
import com.discovermarket.claimservice.services.ClaimService;
import com.discovermarket.core.models.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController()
@RequestMapping("/${endpoint-prefix}/claims")
@Api(tags = {"claims"})
public class ClaimController {

    private final ClaimService service;

    @Autowired
    public ClaimController(ClaimService service) {
        this.service = service;
    }

    @ApiOperation(value = "get answers by claimsId")
    @GetMapping("/{id}/answers")
    public ResponseEntity<List<AutoSaveQuestionDTO>> getAnswerByClaim(@PathVariable("id") String claimId) {
        return ResponseEntity.ok(service.getAnswerByClaim(claimId));
    }

    @ApiOperation(value = "create claim")
    @PostMapping
    public ResponseEntity<CreateClaimResponseDTO> createClaim(@Valid @RequestBody CreateClaimRequest request) {
        return ResponseEntity.ok(service.createClaim(request));
    }

    @ApiOperation(value = "update answers by claimId")
    @PutMapping("/{id}/answers")
    public ResponseEntity<List<AutoSaveQuestionDTO>> updateClaim(@PathVariable("id") String id, @Valid @RequestBody List<ClaimRequest> request) throws Exception {
        return ResponseEntity.ok(service.updateClaim(id, request));
    }

    @ApiOperation(value = "send email")
    @PostMapping("/email")
    public ResponseEntity<ApiResponse> sendEmail(@Valid @RequestBody NotificationSendRequestDTO request) throws Exception {
        return ResponseEntity.ok(service.sendEmail(request));
    }
}
