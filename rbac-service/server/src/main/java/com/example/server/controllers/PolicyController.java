package com.example.server.controllers;

import com.example.server.entities.PolicyEntity;
import com.example.server.services.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/policy")
public class PolicyController {

    @Autowired
    private PolicyService policyService;
    @PostMapping
    public PolicyEntity createPolicy(@RequestBody PolicyEntity policy) {
        return policyService.savePolicy(policy);
    }
    @GetMapping("/{policyId}")
    public Optional<PolicyEntity> getPolicyByPolicyId(@PathVariable("policyId") String policyID) {
        return policyService.getPolicyById(policyID);
    }
    @GetMapping
    public List<PolicyEntity> getAllPolicies() {
        return policyService.getAllPolicies();
    }
    @PutMapping("/{policyId}")
    public Optional<PolicyEntity> updatePolicy(@PathVariable("policyId") String policyId, @RequestBody PolicyEntity updatedPolicy) {
        return policyService.updatePolicy(policyId, updatedPolicy);
    }
    @DeleteMapping("/{policyId}")
    public void deletePolicy(@PathVariable("policyId") String policyId) {
        policyService.deletePolicyById(policyId);
    }
}
