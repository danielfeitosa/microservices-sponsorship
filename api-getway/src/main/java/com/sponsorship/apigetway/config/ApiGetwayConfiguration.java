package com.sponsorship.apigetway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGetwayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder){

        return  builder.routes()
                .route(p->p.path("/get")
                        .filters(f->
                                f.addRequestHeader("Hello","World")
                                        .addRequestParameter("Hello","world")
                        )

                        .uri("http://httpbin.org:80") ).
                route(p->
                        p.path("/sponsored")
                        .uri("lb://SPONSORED-SERVICE"))
                .route(p->
                        p.path("/sponsor")
                                .uri("lb://SPONSOR-SERVICE"))

                .build();
    }
}
