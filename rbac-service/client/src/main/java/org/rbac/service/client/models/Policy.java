package org.rbac.service.client.models;

import lombok.Data;

@Data
public class Policy {
    private String name;

    private Statement[] statements;
}