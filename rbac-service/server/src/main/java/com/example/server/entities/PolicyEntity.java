package com.example.server.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.rbac.service.client.models.Statement;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "policies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PolicyEntity {

    @MongoId(FieldType.OBJECT_ID)
    private String policyId;

    private String name;

    private Statement[] statements;
}
