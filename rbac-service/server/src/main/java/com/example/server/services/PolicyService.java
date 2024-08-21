package com.example.server.services;

import com.example.server.entities.PolicyEntity;

import java.util.List;
import java.util.Optional;

public interface PolicyService {
    PolicyEntity savePolicy(PolicyEntity policy);

    Optional<PolicyEntity> getPolicyById(String policyId);

    Optional<PolicyEntity> getPolicyByNames(String policyName);

    List<PolicyEntity> getAllPolicies();

    Optional<PolicyEntity> updatePolicy(String policyId, PolicyEntity updatedPolicy);

    boolean deletePolicyById(String policyId);
}
