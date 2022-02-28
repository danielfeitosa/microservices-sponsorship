package com.comfort.sponsoredservice.controller;

import com.comfort.sponsoredservice.client.SponsorClient;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("sponsored")
@RequiredArgsConstructor
@Slf4j
public class SponsoredController {
    private final SponsorClient sponsorClient;
    @GetMapping
    @Retry(name = "helloSponsored",fallbackMethod = "fallbackMethod")
    public String getHelloSponsored(){
        String show = sponsorClient.show();
        log.info("public String getHelloSponsored()");
        new RestTemplate().getForEntity("http://localhost:8084/sponsorer",SponsorClient.class);
        return show + " Hello Sponsored";
    }
    public String fallbackMethod(Exception e){
        return "Hello Sponsored fallbackMethod ";
    }
}
