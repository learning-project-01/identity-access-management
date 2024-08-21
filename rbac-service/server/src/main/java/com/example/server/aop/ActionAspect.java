package com.example.server.aop;

import com.example.server.annotations.Action;
import com.example.server.services.UserStatementProvider;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.rbac.service.client.models.Statement;
import org.rbac.service.client.models.StatementRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Aspect
@Component
@Slf4j
public class ActionAspect {

    @Autowired
    UserStatementProvider userStatementProvider;


    @Before("@annotation(action)")
    public void beforeAction(JoinPoint joinPoint, Action action) {
        log.info("Action name: " + action.name());
        List<Statement> userStatements = userStatementProvider.getUserStatements();

        String actionName = action.name();
        String effect = action.effect();
        String requestResourceId = getRequestResourceId(joinPoint);

        if (requestResourceId == null) {
            requestResourceId = action.resourceId();
        }
        StatementRecord statementRecord = new StatementRecord(effect, actionName, requestResourceId);

        String actionResourceId = action.resourceId();

        if (userStatements == null || userStatements.isEmpty()) {
            throw new RuntimeException("User statements not found");
        }
        Set<StatementRecord> recordSet = userStatements.stream().flatMap(statement -> {

            return List.of(statement.getActions())
                    .stream()
                    .map(actionItem -> new StatementRecord(statement.getEffect(), actionItem, statement.getResourceId()));

        }).collect(Collectors.toSet());

        checkPermission(recordSet, statementRecord);

    }

//    private void checkPermission(Set<StatementRecord> recordSet, StatementRecord statementRecord) {
//        if (!recordSet.contains(statementRecord)) {
//
//            statementRecord.setResourceId("*");
//            if (!recordSet.contains(statementRecord)) {
//                statementRecord.setAction("*");
//                if (!recordSet.contains(statementRecord)) {
//                    throw new RuntimeException("Access denied " + recordSet);
//                }
//            }
//            //
//        }
//    }

    private void checkPermission(Set<StatementRecord> recordSet, StatementRecord statementRecord) {
        log.info("Checking permission for statementRecord: {}", statementRecord);
        log.info("Available records: {}", recordSet);

        if (!recordSet.contains(statementRecord)) {
            statementRecord.setResourceId("*");
            log.info("Checking with wildcard resourceId: {}", statementRecord);

            if (!recordSet.contains(statementRecord)) {
                statementRecord.setAction("*");
                log.info("Checking with wildcard action: {}", statementRecord);

                if (!recordSet.contains(statementRecord)) {
                    throw new RuntimeException("Access denied " + recordSet);
                }
            }
        }
    }


    private String getRequestResourceId(JoinPoint joinPoint) {
        Object[] joinPointArgs = joinPoint.getArgs();
        if (joinPointArgs == null) return null;
        if (joinPointArgs.length == 0) return null;
        Object resourceId = joinPointArgs[0];
        if (StringUtils.isEmpty(resourceId)) return null;
        if (resourceId instanceof String || resourceId instanceof Integer || resourceId instanceof Float) {
            return resourceId.toString();
        }
        return null;
    }

}
