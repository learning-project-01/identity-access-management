package com.example.server.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Document(collection = "user-policies")
@AllArgsConstructor
@NoArgsConstructor
public class UserPoliciesEntity {

    @MongoId
    private String userId;

    private String[] policyIds;
}