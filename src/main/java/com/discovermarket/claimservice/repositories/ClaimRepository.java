package com.discovermarket.claimservice.repositories;

import com.discovermarket.claimservice.entities.Claim;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaimRepository extends MongoRepository<Claim, ObjectId>, ClaimRepositoryCustom {
}
