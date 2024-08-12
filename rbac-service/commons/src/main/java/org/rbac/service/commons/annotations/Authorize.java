package org.rbac.service.commons.annotations;

import org.rbac.service.commons.models.Permission;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Authorize {
    String resource() default "";
    Permission permission() default Permission.ALL;
}
