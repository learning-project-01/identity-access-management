package com.example.server.services.impl;

import com.example.server.entities.UserPoliciesEntity;
import com.example.server.services.UserPolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserPolicyServiceImpl implements UserPolicyService {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public UserPoliciesEntity saveUserPolicy(UserPoliciesEntity userPolicies) {
        return mongoTemplate.save(userPolicies);
    }

    @Override
    public Optional<UserPoliciesEntity> getUserAssociatedPolicies(String userId) {
        Query query = new Query(Criteria.where("userId").is(userId));
        UserPoliciesEntity userPolicies = mongoTemplate.findOne(query, UserPoliciesEntity.class);
        return Optional.ofNullable(userPolicies);
    }
}