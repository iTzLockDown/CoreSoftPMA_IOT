package com.PMACORESOFT.coresoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CoresoftApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoresoftApplication.class, args);
	}

}
