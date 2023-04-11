package com.discovermarket.claimservice.models;

import java.util.List;

public class AnswersDTO {

    private String answerValue;

    private List<AutoSaveQuestionDTO> additionalQuestions;

    public String getAnswerValue() {
        return answerValue;
    }

    public void setAnswerValue(String answerValue) {
        this.answerValue = answerValue;
    }

    public List<AutoSaveQuestionDTO> getAdditionalQuestions() {
        return additionalQuestions;
    }

    public void setAdditionalQuestions(List<AutoSaveQuestionDTO> additionalQuestions) {
        this.additionalQuestions = additionalQuestions;
    }
}
