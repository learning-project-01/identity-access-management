package org.rbac.service.client.models;

import lombok.*;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class StatementRecord {
    private String effect;

    private String action;

    private String resourceId;
}
