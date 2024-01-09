package org.rbac.service.commons.annotations;

import org.rbac.service.commons.models.Permission;

public @interface Authorize {
    String resource() default "";
    Permission permission() default Permission.ALL;
}
