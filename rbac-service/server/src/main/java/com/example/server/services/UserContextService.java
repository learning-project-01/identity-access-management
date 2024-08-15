package com.example.server.services;

import org.rbac.service.client.models.Statement;

import java.util.List;

public interface UserContextService {
    List<Statement> getUserStatements();

    void setUserStatements(List<Statement> userStatements);
}
