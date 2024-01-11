package org.rbac.service.commons.resources;

import org.rbac.service.commons.annotations.Authorize;
import org.rbac.service.commons.models.Permission;

@Authorize(resource = "TEST", permission = Permission.ALL)
public class ApplicationResource {
    @Authorize(resource = "TEST", permission = Permission.ALL)
    public String getResult() {
        return null;
    }


    //              EXTRA CODE FOR DEMONSTRATION (can be removed after usage end)
    @Authorize(resource = "TEST Database", permission = Permission.READ)
    public String getUser() {
        return "read-only";
    }

    @Authorize(resource = "TEST Production", permission = Permission.WRITE)
    public String getUser1() {
        return "write-only";
    }

    //                  EXTRA CODE END

}
