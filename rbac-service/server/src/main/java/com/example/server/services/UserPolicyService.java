package com.example.server.services;

import com.example.server.entities.UserPoliciesEntity;

import java.util.Optional;

public interface UserPolicyService {
    UserPoliciesEntity saveUserPolicy(UserPoliciesEntity userPolicies);

    Optional<UserPoliciesEntity> getUserAssociatedPolicies(String userId);
}