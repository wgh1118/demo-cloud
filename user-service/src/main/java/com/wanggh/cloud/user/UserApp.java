package com.wanggh.cloud.user;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@EnableJpaAuditing
@SpringBootApplication
@RestController
@RefreshScope
public class UserApp {

    public static void main(String[] args) {
        SpringApplication.run(UserApp.class, args);
    }

    @Value("${name}")
    String name;

    @RequestMapping(value = "/name")
    public String name() {
        return name;
    }
}
