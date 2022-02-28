package com.comfort.sponsoredservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("sponsor-service")
public interface SponsorClient {
    @GetMapping("/api/v1/sponsor")
    public String show();
}
