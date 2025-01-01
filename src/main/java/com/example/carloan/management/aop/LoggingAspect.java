package com.example.carloan.management.aop;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.util.Enumeration;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
    private final ObjectMapper objectMapper = new ObjectMapper(); // For JSON serialization

    @Around("execution(* com.example.carloan.management.controller..*(..))")
    public Object logRequestsAndResponses(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("Entering method: {}", joinPoint.getSignature());

        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (arg instanceof HttpServletRequest) {
                HttpServletRequest request = (HttpServletRequest) arg;
                logRequestDetails(request);
            }
        }

        Object result;
        try {
            result = joinPoint.proceed();
            logResponse(result);
        } catch (Throwable throwable) {
            logger.error("Exception in method: {}", joinPoint.getSignature(), throwable);
            throw throwable;
        }

        logger.info("Exiting method: {}", joinPoint.getSignature());
        return result;
    }

    private void logRequestDetails(HttpServletRequest request) {
        logger.info("HTTP Method: {}", request.getMethod());
        logger.info("Request URI: {}", request.getRequestURI());
        logger.info("Query Params: {}", request.getQueryString());
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            logger.info("Header: {} = {}", headerName, request.getHeader(headerName));
        }
    }

    private void logResponse(Object result) {
        try {
            // Serialize the response object to JSON
            String jsonResponse = objectMapper.writeValueAsString(result);
            logger.info("Response: {}", jsonResponse);
        } catch (Exception e) {
            logger.error("Failed to log response: {}", e.getMessage());
        }
    }
}
