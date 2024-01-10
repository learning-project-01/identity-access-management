package org.rbac.service.commons.resources;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.rbac.service.commons.annotations.Authorize;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ApplicationResourceTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getResult() {

        ApplicationResource applicationResource = new ApplicationResource();
        String result = applicationResource.getResult();
        assertNull(result);

        Class<ApplicationResource> classElements = ApplicationResource.class;
        boolean annotationPresence = classElements.isAnnotationPresent(Authorize.class);


        String resourceName = null;
        String permissionType = null;
        if (annotationPresence) {

            Authorize authorize = classElements.getAnnotation(Authorize.class);
            resourceName = authorize.resource();
            permissionType = String.valueOf(authorize.permission());

            System.out.printf("The user is accessing - " + resourceName + " " + "The user has Permission type - " + resourceName);


        }
        assertEquals(resourceName, "TEST");
        assertEquals(permissionType, "ALL");


    }


    @Test
    void getUser() {
    }

    @Test
    void getUser1() {
    }


}