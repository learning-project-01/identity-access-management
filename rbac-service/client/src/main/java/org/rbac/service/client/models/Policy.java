package org.rbac.service.client.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Policy {

    private String policyId;

    private String name;

    private Statement[] statements;
}