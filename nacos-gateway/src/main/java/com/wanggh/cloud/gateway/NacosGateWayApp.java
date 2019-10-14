package com.wanggh.cloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class NacosGateWayApp {
    public static void main(String[] args) {
        SpringApplication.run(NacosGateWayApp.class, args);
    }
}
