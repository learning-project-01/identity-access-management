package org.rbac.service.commons.models;

import java.util.Objects;

public class ResourcePermission {
    private String resourceName;
    private Permission permission;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResourcePermission that = (ResourcePermission) o;
        return Objects.equals(resourceName, that.resourceName) && permission == that.permission;
    }

    @Override
    public int hashCode() {
        return Objects.hash(resourceName, permission);
    }
}
