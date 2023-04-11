package com.discovermarket.claimservice.repositories;

import com.discovermarket.claimservice.entities.embedded.ClaimQuestion;
import org.bson.types.ObjectId;

import java.util.List;

public interface ClaimRepositoryCustom {

    Long updateClaimToEntity(ObjectId idClaim, List<ClaimQuestion> claimQuestions);
}
