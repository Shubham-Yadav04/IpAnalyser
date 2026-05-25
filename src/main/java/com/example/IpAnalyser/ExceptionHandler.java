package com.example.IpAnalyser;

import graphql.GraphQLError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.GraphQlExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
@Slf4j
public class ExceptionHandler {


    @GraphQlExceptionHandler
    public GraphQLError handleRuntime(Exception ex){
        log.error(ex.getMessage());
        return GraphQLError.newError().message(ex.getMessage()).build();
    }
}
