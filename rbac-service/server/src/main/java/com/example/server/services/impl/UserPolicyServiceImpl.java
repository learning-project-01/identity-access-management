package com.example.server.services.impl;

import com.example.server.entities.PolicyEntity;
import com.example.server.entities.UserPoliciesEntity;
import com.example.server.services.PolicyService;
import com.example.server.services.UserPolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserPolicyServiceImpl implements UserPolicyService {

    @Autowired
    private PolicyService policyService;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public UserPoliciesEntity saveUserPolicy(UserPoliciesEntity userPolicies) {
        return mongoTemplate.save(userPolicies);
    }

    @Override
    public Optional<List<PolicyEntity>> getUserAssociatedPolicies(String userId) {
        Query query = new Query(Criteria.where("userId").is(userId));
        UserPoliciesEntity userPolicies = mongoTemplate.findOne(query, UserPoliciesEntity.class);

        if (userPolicies == null) return Optional.empty();
        if (userPolicies.getPolicyNames() == null) return Optional.empty();

        List<PolicyEntity> collectedUserPolicies = Arrays.stream(userPolicies.getPolicyNames())
                .map(policyService::getPolicyByNames)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());

        return Optional.of(collectedUserPolicies);
    }

    @Override
    public void removeUserAssociatedPolicies(String userId) {
        Query query = new Query(Criteria.where("userId").is(userId));
        Update update = new Update().set("policyNames", null);
        mongoTemplate.updateFirst(query, update, UserPoliciesEntity.class);
    }
}