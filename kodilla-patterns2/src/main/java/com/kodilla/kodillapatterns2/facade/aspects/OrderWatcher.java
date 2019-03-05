package com.kodilla.kodillapatterns2.facade.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class OrderWatcher {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderWatcher.class);

    @Before("execution(* com.kodilla.kodillapatterns2.facade.api.OrderFacade.processOrder(..))")
    public void logEvent() {
        LOGGER.info("==============================================");
        LOGGER.info("========= Beginning order processing =========");
        LOGGER.info("==============================================");
    }
}
