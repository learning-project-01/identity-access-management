package com.example.server.services.impl;

import com.example.server.entities.PolicyEntity;
import com.example.server.services.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PolicyServiceImpl implements PolicyService {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public PolicyEntity savePolicy(PolicyEntity policy) {
        return mongoTemplate.save(policy);
    }

    @Override
    public Optional<PolicyEntity> getPolicyById(String policyId) {
        Query query = new Query(Criteria.where("policyId").is(policyId));
        PolicyEntity policy = mongoTemplate.findOne(query, PolicyEntity.class);
        return Optional.ofNullable(policy);
    }

    @Override
    public List<PolicyEntity> getAllPolicies() {
        return mongoTemplate.findAll(PolicyEntity.class);
    }

    @Override
    public Optional<PolicyEntity> updatePolicy(String policyId, PolicyEntity updatedPolicy) {
        Query query = new Query(Criteria.where("policyId").is(policyId));
        Update update = new Update().set("name", updatedPolicy.getName()).set("statements", updatedPolicy.getStatements());

        mongoTemplate.findAndModify(query, update, PolicyEntity.class);
        return getPolicyById(policyId);
    }

    @Override
    public boolean deletePolicyById(String policyId) {
        Query query = new Query(Criteria.where("policyId").is(policyId));
        return mongoTemplate.remove(query, PolicyEntity.class).getDeletedCount() > 0;
    }

}