package com.discovermarket.claimservice.request;

import org.bson.types.ObjectId;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class ClaimRequest {

    @NotNull
    private ObjectId questionIdentifier;

    private List<@Valid AnswersRequest> answers;

    private List<ClaimRequest> additionalQuestions;

    public ObjectId getQuestionIdentifier() {
        return questionIdentifier;
    }

    public void setQuestionIdentifier(ObjectId questionIdentifier) {
        this.questionIdentifier = questionIdentifier;
    }

    public List<AnswersRequest> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswersRequest> answers) {
        this.answers = answers;
    }

    public List<ClaimRequest> getAdditionalQuestions() {
        return additionalQuestions;
    }

    public void setAdditionalQuestions(List<ClaimRequest> additionalQuestions) {
        this.additionalQuestions = additionalQuestions;
    }
}
