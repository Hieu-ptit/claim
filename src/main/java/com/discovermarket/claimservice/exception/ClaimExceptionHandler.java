package com.discovermarket.claimservice.exception;

import com.discovermarket.core.models.FailureApiResponse;
import com.discovermarket.core.ultilities.ErrorMessageConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ClaimExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClaimExceptionHandler.class);

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<FailureApiResponse> handleRunTimeException(RuntimeException e) {
        LOGGER.error(e.getMessage(), e);

        FailureApiResponse failureApiResponse = new FailureApiResponse(ErrorMessageConstants.INTERNAL_SERVER_ERROR);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(failureApiResponse);
    }

    @ExceptionHandler({LobNotFoundException.class, ClaimNotFoundException.class})
    public ResponseEntity<FailureApiResponse> handleLobNotFoundException(Exception exception) {

        LOGGER.warn(exception.getMessage(), exception);

        FailureApiResponse failureApiResponse = new FailureApiResponse(exception.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(failureApiResponse);
    }
}