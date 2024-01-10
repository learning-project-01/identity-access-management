package org.rbac.service.commons.resources;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationResourceTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void getResult() {

        ApplicationResource applicationResource = new ApplicationResource();
        String result = applicationResource.getResult();
        assertEquals(null,result);

    }
}