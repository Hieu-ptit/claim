package com.discovermarket.claimservice.entities.embedded;

import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.io.Serializable;
import java.util.List;
@Embeddable
public class Answer implements Serializable {

    @Field("answer_value")
    private String answerValue;

    public String getAnswerValue() {
        return answerValue;
    }

    public void setAnswerValue(String answersValue) {
        this.answerValue = answersValue;
    }

}
