package org.rbac.service.commons.models;

import java.util.Set;

public class AuthUser {
    private String username;
    private String token;
    private Set<AuthPermission> authPermissions;
}
