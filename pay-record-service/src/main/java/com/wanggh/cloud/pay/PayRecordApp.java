package com.wanggh.cloud.pay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.client.RestTemplate;

@EnableFeignClients(basePackages = {"com.wanggh.cloud.pay.feign"})
@EnableDiscoveryClient
@EnableJpaAuditing
@SpringBootApplication
public class PayRecordApp {

    public static void main(String[] args) {
        SpringApplication.run(PayRecordApp.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
