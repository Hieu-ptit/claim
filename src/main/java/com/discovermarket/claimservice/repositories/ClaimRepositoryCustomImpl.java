package com.discovermarket.claimservice.repositories;

import com.discovermarket.claimservice.entities.Claim;
import com.discovermarket.claimservice.entities.embedded.ClaimQuestion;
import com.mongodb.client.result.UpdateResult;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClaimRepositoryCustomImpl implements ClaimRepositoryCustom {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Long updateClaimToEntity(ObjectId idClaim, List<ClaimQuestion> claimQuestions) {
        Query query = new Query().addCriteria(new Criteria("id").is(idClaim));
        Update update = Update.update("claim_questions", claimQuestions);
        UpdateResult updateResult = mongoTemplate.updateFirst(query, update, Claim.class);
        return updateResult.getMatchedCount();
    }
}
