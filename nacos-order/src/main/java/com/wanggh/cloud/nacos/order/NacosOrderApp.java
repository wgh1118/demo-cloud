package com.wanggh.cloud.nacos.order;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;


@EnableDistributedTransaction
@EnableTransactionManagement
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.wanggh.cloud.nacos.order.rpc"})
@EnableJpaAuditing
@SpringBootApplication
public class NacosOrderApp {
    public static void main(String[] args) {
        SpringApplication.run(NacosOrderApp.class, args);
    }
}
