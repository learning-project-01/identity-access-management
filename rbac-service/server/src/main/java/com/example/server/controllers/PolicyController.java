package com.example.server.controllers;

import org.rbac.service.client.models.Policy;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/policy")
public class PolicyController {

    @PostMapping
    public Policy createPolicy(@RequestBody Policy policy) {
        return policy;
    }

    @GetMapping("/{policy-name}")
    public Policy getPolicy(@PathVariable("policy-name") String policyName) {
        Policy policy = new Policy();
        policy.setName(policyName);
        return policy;
    }
}
