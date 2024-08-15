package com.example.server.services.impl;

import com.example.server.services.UserAuthenticationService;
import com.example.server.services.UserContextService;
import org.rbac.service.client.models.Statement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserAuthenticationServiceImpl implements UserAuthenticationService {

    @Autowired
    private UserContextService userContextService;

    @Override
    public void userLogin(String username, String password) {

        // Since we don't have the controller and service for the statement model I passed this empty list of statements
        List<Statement> statements = new ArrayList<>();

        userContextService.setUserStatements(statements);
    }
}
