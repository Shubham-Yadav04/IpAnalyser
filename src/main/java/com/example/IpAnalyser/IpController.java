package com.example.IpAnalyser;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
@RequiredArgsConstructor
public class IpController {

private final IpService ipService;
    @QueryMapping
    public IpAnalysis analyzeIp(@Argument String ip){
        try{
            IpAnalysis response= ipService.getCountry(ip);
            log.info("the country of the entered ip : {} is {}",ip,response.country);
            return response;
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

    }
}
