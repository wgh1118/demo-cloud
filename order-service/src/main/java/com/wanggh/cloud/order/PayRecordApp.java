package com.wanggh.cloud.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@EnableDiscoveryClient
@EnableJpaAuditing
@SpringBootApplication
public class PayRecordApp {

	public static void main(String[] args) {
		SpringApplication.run(PayRecordApp.class, args);
	}

}
