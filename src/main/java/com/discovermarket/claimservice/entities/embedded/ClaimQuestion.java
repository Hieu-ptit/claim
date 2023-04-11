package com.discovermarket.claimservice.entities.embedded;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.io.Serializable;
import java.util.List;
@Embeddable
public class ClaimQuestion implements Serializable {

    @Field("question_identifier")
    private ObjectId questionIdentifier;

    @Field("question_sequence")
    private Integer questionSequence;

    @Embedded
    @Field("answers")
    private List<Answer> answers;

    @Embedded
    @Field("additional_questions")
    private List<ClaimQuestion> additionalQuestions;

    public ObjectId getQuestionIdentifier() {
        return questionIdentifier;
    }

    public void setQuestionIdentifier(ObjectId questionIdentifier) {
        this.questionIdentifier = questionIdentifier;
    }

    public Integer getQuestionSequence() {
        return questionSequence;
    }

    public void setQuestionSequence(Integer questionSequence) {
        this.questionSequence = questionSequence;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public List<ClaimQuestion> getAdditionalQuestions() {
        return additionalQuestions;
    }

    public void setAdditionalQuestions(List<ClaimQuestion> additionalQuestions) {
        this.additionalQuestions = additionalQuestions;
    }
}
