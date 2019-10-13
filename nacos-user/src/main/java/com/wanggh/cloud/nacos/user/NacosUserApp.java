package com.wanggh.cloud.nacos.user;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableDistributedTransaction
@EnableTransactionManagement
@EnableJpaAuditing
@EnableDiscoveryClient
@SpringBootApplication
public class NacosUserApp {
    public static void main(String[] args) {
        SpringApplication.run(NacosUserApp.class, args);
    }
}
