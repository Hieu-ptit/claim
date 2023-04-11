package com.discovermarket.claimservice;

import com.discovermarket.claimservice.clients.CommonClient;
import com.discovermarket.claimservice.clients.NotificationClient;
import com.discovermarket.claimservice.clients.TenantClient;
import com.discovermarket.claimservice.entities.Claim;
import com.discovermarket.claimservice.entities.embedded.Answer;
import com.discovermarket.claimservice.entities.embedded.ClaimQuestion;
import com.discovermarket.claimservice.exception.ClaimNotFoundException;
import com.discovermarket.claimservice.exception.LobNotFoundException;
import com.discovermarket.claimservice.models.*;
import com.discovermarket.claimservice.repositories.ClaimRepository;
import com.discovermarket.claimservice.request.AnswersRequest;
import com.discovermarket.claimservice.request.ClaimRequest;
import com.discovermarket.claimservice.request.CreateClaimRequest;
import com.discovermarket.claimservice.request.NotificationSendRequestDTO;
import com.discovermarket.claimservice.services.impl.ClaimServiceImpl;
import com.discovermarket.claimservice.utilities.ErrorCode;
import com.discovermarket.core.models.ApiResponse;
import com.discovermarket.core.ultilities.ErrorMessageConstants;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;

@ExtendWith(MockitoExtension.class)
public class ClaimServiceImplTest {

    @Mock
    private ClaimRepository claimRepository;

    @Mock
    private CommonClient commonClient;

    @Mock
    private TenantClient tenantClient;

    @Mock
    private NotificationClient notificationClient;

    @Spy
    private ModelMapper modelMapper;

    @InjectMocks
    private ClaimServiceImpl claimService;

    @Test
    public void testGetQuestion() throws Exception {
        ObjectId idQuestion = new ObjectId("62216f8f4496ab4980892fdb");
        ObjectId idClaim = new ObjectId();
        Mockito.when(claimRepository.findById(idClaim)).thenReturn(Optional.of(getClaim()));
        List<AutoSaveQuestionDTO> claimUpdateDTOS = claimService.getAnswerByClaim(idClaim.toHexString());
        assertEquals(claimUpdateDTOS.size(), 1);
        assertEquals(claimUpdateDTOS.get(0).getQuestionIdentifier(), idQuestion.toHexString());
        assertEquals(claimUpdateDTOS.get(0).getAnswers().get(0).getAnswerValue(), "hhh");
//        assertEquals(claimUpdateDTOS.get(0).getAnswers().get(0).getAdditionalQuestions().get(0).getQuestionIdentifier(), idQuestion);
//        assertEquals(claimUpdateDTOS.get(0).getAnswers().get(0).getAdditionalQuestions().get(0).getQuestionSequence(), 1000);
    }

    @Test
    public void testGetQuestionNull() {
        ObjectId idClaim = new ObjectId();
        Mockito.when(claimRepository.findById(idClaim)).thenReturn(Optional.empty());
        Exception exception = assertThrows(ClaimNotFoundException.class, () -> claimService.getAnswerByClaim(idClaim.toHexString()));
        assertEquals(exception.getMessage(), ErrorCode.CLAIM_NOT_FOUND);
    }

    @Test
    public void testUpdateClaim() throws Exception {
        ObjectId idClaim = new ObjectId();
        Mockito.when(claimRepository.updateClaimToEntity(any(), anyList())).thenReturn(1L);
        List<AutoSaveQuestionDTO> claimUpdateDTOS = claimService.updateClaim(idClaim.toHexString(), getClaimRequest());
        assertEquals(claimUpdateDTOS.size(), getClaimRequest().size());
        assertEquals(claimUpdateDTOS.get(0).getQuestionIdentifier(), getClaimRequest().get(0).getQuestionIdentifier().toHexString());
        assertEquals(claimUpdateDTOS.get(0).getAnswers().get(0).getAnswerValue(), getAnswersRequests().get(0).getAnswerValue());
    }

    @Test
    public void testUpdateClaimFailed() {
        ObjectId idClaim = new ObjectId();
        Mockito.when(claimRepository.updateClaimToEntity(any(), anyList())).thenReturn(0L);
        Exception exception = assertThrows(Exception.class, () -> claimService.updateClaim(idClaim.toHexString(), getClaimRequest()));
        assertEquals(ErrorCode.CLAIM_NOT_FOUND, exception.getMessage());
    }

    @Test
    public void testCreateClaim() {
        CreateClaimRequest createClaimRequest = new CreateClaimRequest();
        createClaimRequest.setLineOfBusinessIdentifier(new ObjectId());

        Claim saveResponse = new Claim();
        saveResponse.setId(new ObjectId());

        Optional<LobResponse> lobResponse = Optional.of(getLobResponse());

        Mockito.when(commonClient.getLobDetails(createClaimRequest.getLineOfBusinessIdentifier().toHexString())).thenReturn(lobResponse);
        Mockito.when(claimRepository.save(any())).thenReturn(saveResponse);

        CreateClaimResponseDTO actual = claimService.createClaim(createClaimRequest);
        CreateClaimResponseDTO expected = new CreateClaimResponseDTO();
        expected.setId(saveResponse.getId().toHexString());

        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getStatus(), actual.getStatus());


    }

    @Test
    public void testCreateFailed() {
        CreateClaimRequest createClaimRequest = new CreateClaimRequest();
        createClaimRequest.setLineOfBusinessIdentifier(new ObjectId());

        Claim saveResponse = new Claim();
        saveResponse.setId(new ObjectId());

        Optional<LobResponse> lobResponse = Optional.empty();

        Mockito.when(commonClient.getLobDetails(createClaimRequest.getLineOfBusinessIdentifier().toHexString())).thenReturn(lobResponse);

        Exception exception = assertThrows(LobNotFoundException.class, () -> claimService.createClaim(createClaimRequest));
        assertEquals(ErrorMessageConstants.TENANT_IS_INACTIVE, exception.getMessage());
    }

    @Test
    public void testSendEmail() throws IOException {
        Mockito.when(tenantClient.getTenantById(any())).thenReturn(new TenantResponse());
        Mockito.when(tenantClient.getTenantConfigurationTemplate(any(), any(), any())).thenReturn(new Template());
        Mockito.when(notificationClient.sendEmail(any())).thenReturn(new SendEmailResponseDTO());
        ApiResponse apiResponse = claimService.sendEmail(new NotificationSendRequestDTO());
        assertEquals(apiResponse.getStatus(), HttpStatus.OK);
    }

    private List<ClaimRequest> getClaimRequest() {
        ObjectId idQuestion = new ObjectId("62216f8f4496ab4980892fdb");
        ClaimRequest claimRequest = new ClaimRequest();
        claimRequest.setQuestionIdentifier(idQuestion);
        claimRequest.setAnswers(getAnswersRequests());
//        claimRequest.setQuestionSequence(1);
        claimRequest.setAdditionalQuestions(null);
        return Arrays.asList(claimRequest);
    }

    private List<AnswersRequest> getAnswersRequests() {
        AnswersRequest answersRequest = new AnswersRequest();
        answersRequest.setAnswerValue("answerValue");
//        answersRequest.setAdditionalQuestions(null);
        return Arrays.asList(answersRequest);
    }

    private Claim getClaim() {
        Claim claim = new Claim();
        claim.setClaimQuestions(getClaimQuestions());
        return claim;
    }

    private List<ClaimQuestion> getClaimQuestions() {
        ObjectId idQuestion = new ObjectId("62216f8f4496ab4980892fdb");
        ClaimQuestion claimQuestion = new ClaimQuestion();
        claimQuestion.setQuestionIdentifier(idQuestion);
        claimQuestion.setQuestionSequence(9999);
        claimQuestion.setAnswers(getAnswers());
        return Arrays.asList(claimQuestion);
    }

    private List<Answer> getAnswers() {
        Answer answers = new Answer();
        answers.setAnswerValue("hhh");
//        answers.setAdditionalQuestions(getAdditionalQuestions());
        return Arrays.asList(answers);
    }

    private List<ClaimQuestion> getAdditionalQuestions() {
        ObjectId idQuestion = new ObjectId("62216f8f4496ab4980892fdb");
        ClaimQuestion claimQuestion = new ClaimQuestion();
        claimQuestion.setQuestionIdentifier(idQuestion);
        claimQuestion.setQuestionSequence(1000);
        return Arrays.asList(claimQuestion);
    }

    private LobResponse getLobResponse() {
        LobResponse lobResponse = new LobResponse();
        lobResponse.setId(new ObjectId().toString());
        return lobResponse;
    }
}
