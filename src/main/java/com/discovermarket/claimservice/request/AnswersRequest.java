package com.discovermarket.claimservice.request;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class AnswersRequest {

    @NotBlank
    private String answerValue;

    public String getAnswerValue() {
        return answerValue;
    }

    public void setAnswerValue(String answerValue) {
        this.answerValue = answerValue;
    }

}
