package com.example.server.controllers;

import com.example.server.annotations.Action;
import com.example.server.services.UserStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestPermissionController {


    @Autowired
    private UserStatementProvider userStatementProvider;

    @Action(name = "read", resourceId = "r1")
    @GetMapping("/read/{resourceId}")
    public String readResource(@PathVariable String resourceId) {
        return "Read permission for :" + resourceId;
    }

    @Action(name = "write", resourceId = "r2")
    @GetMapping("/write/{resourceId}")
    public String writeResource(@PathVariable String resourceId) {
        return "Write permission for resource: " + resourceId;
    }

    @Action(name = "delete", resourceId = "r4")
    @GetMapping("/delete/{resourceId}")
    public String deleteResource(@PathVariable String resourceId) {
        return "Delete permission for resource: " + resourceId;
    }

    @Action(name = "update", resourceId = "r4")
    @GetMapping("/update/{resourceId}")
    public String updateResource(@PathVariable String resourceId) {
        return "Update permission for resource: " + resourceId;
    }
}
