package com.discovermarket.claimservice.models;

import java.util.List;

public class AutoSaveQuestionDTO {

    private String questionIdentifier;

    private List<AnswersDTO> answers;

    private List<AutoSaveQuestionDTO> additionalQuestions;

    public String getQuestionIdentifier() {
        return questionIdentifier;
    }

    public void setQuestionIdentifier(String questionIdentifier) {
        this.questionIdentifier = questionIdentifier;
    }

    public List<AnswersDTO> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswersDTO> answers) {
        this.answers = answers;
    }

    public List<AutoSaveQuestionDTO> getAdditionalQuestions() {
        return additionalQuestions;
    }

    public void setAdditionalQuestions(List<AutoSaveQuestionDTO> additionalQuestions) {
        this.additionalQuestions = additionalQuestions;
    }
}
