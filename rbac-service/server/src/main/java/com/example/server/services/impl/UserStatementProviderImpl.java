package com.example.server.services.impl;

import com.example.server.services.UserStatementProvider;
import jakarta.annotation.PostConstruct;
import org.rbac.service.client.models.Statement;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

@Service
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserStatementProviderImpl implements UserStatementProvider {
    private List<Statement> userStatements;

    // Dummy UserStatements for TestPermissionController
    @PostConstruct
    public void init() {
        this.userStatements = (List.of(
                new Statement("allow", new String[]{"read", "write"}, "r1"),
                new Statement("allow", new String[]{"write"}, "r2"),
                new Statement("allow", new String[]{"read", "write", "delete"}, "r3"),
                new Statement("allow", new String[]{"read", "write", "update", "delete"}, "r4")
        ));
    }

    @Override
    public List<Statement> getUserStatements() {
        return userStatements;
    }

    @Override
    public void setUserStatements(List<Statement> userStatements) {
        this.userStatements = userStatements;
    }
}
