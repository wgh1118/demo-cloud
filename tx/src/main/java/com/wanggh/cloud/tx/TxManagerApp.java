package com.wanggh.cloud.tx;

import com.codingapi.txlcn.tm.config.EnableTransactionManagerServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableTransactionManagerServer
@EnableDiscoveryClient
@SpringBootApplication
public class TxManagerApp {
    public static void main(String[] args) {
        SpringApplication.run(TxManagerApp.class, args);
    }
}
