package org.rbac.service.client.models;

import lombok.Data;

@Data
public class Statement {
    private String effect;

    private String[] actions;

    private String resourceId;
}
