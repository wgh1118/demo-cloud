package com.wanggh.cloud.authorization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@EnableDiscoveryClient
@EnableFeignClients("com.wanggh.cloud.authorization.rpc")
@SpringBootApplication
@EnableResourceServer
public class AuthorizationApp {
    public static void main(String[] args) {
        SpringApplication.run(AuthorizationApp.class, args);
    }
}
