package com.example.server.controllers;

import com.example.server.entities.PolicyEntity;
import com.example.server.entities.UserPoliciesEntity;
import com.example.server.services.UserPolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/userpolicy")
public class UserPolicyController {
    @Autowired
    private UserPolicyService userPolicyService;

    @PutMapping("/{userId}")
    public UserPoliciesEntity assignUserPolicies(@PathVariable("userId") String userId, @RequestBody String[] policyIds) {
        UserPoliciesEntity userPolicies = new UserPoliciesEntity(userId, policyIds);
        return userPolicyService.saveUserPolicy(userPolicies);
    }

    @GetMapping("/{userId}")
    public Optional<List<PolicyEntity>> getUserPolicies(@PathVariable("userId") String userId) {
        return userPolicyService.getUserAssociatedPolicies(userId);
    }

    @DeleteMapping("/{userId}")
    public void removeUserPolicies(@PathVariable("userId") String userId) {
        userPolicyService.removeUserAssociatedPolicies(userId);
    }

}