package com.example.server.services.impl;

import com.example.server.services.UserContextService;
import org.rbac.service.client.models.Statement;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserContextServiceImpl implements UserContextService {

    private List<Statement> userStatements;

    @Override
    public List<Statement> getUserStatements() {
        return userStatements;
    }

    @Override
    public void setUserStatements(List<Statement> userStatements) {
        this.userStatements = userStatements;
    }
}