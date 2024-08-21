package com.example.server.services;

import com.example.server.entities.PolicyEntity;
import com.example.server.entities.UserPoliciesEntity;

import java.util.List;
import java.util.Optional;

public interface UserPolicyService {
    UserPoliciesEntity saveUserPolicy(UserPoliciesEntity userPolicies);

    Optional<List<PolicyEntity>> getUserAssociatedPolicies(String userId);

    void removeUserAssociatedPolicies(String userId);
}