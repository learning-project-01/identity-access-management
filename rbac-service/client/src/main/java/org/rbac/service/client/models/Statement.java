package org.rbac.service.client.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Statement {

    private String effect;

    private String[] actions;

    private String resourceId;
}
