package com.example.server.aop;

import com.example.server.annotations.Action;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class ActionAspect {
    @Before("@annotation(action)")
    public void beforeAction(JoinPoint joinPoint, Action action) {
        log.info("Action name: " + action.name());
    }
}
