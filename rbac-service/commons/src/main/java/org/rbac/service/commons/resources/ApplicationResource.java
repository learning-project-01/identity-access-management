package org.rbac.service.commons.resources;

import org.rbac.service.commons.annotations.Authorize;
import org.rbac.service.commons.models.Permission;

public class ApplicationResource {
    @Authorize(resource = "TEST", permission= Permission.ALL)
    public String getResult(){
        return null;
    }
}
