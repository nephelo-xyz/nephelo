package com.nephelo.oss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient  //激活eureka中的DiscoveryClient实现
@SpringBootApplication
public class NepheloOssApplication {

	public static void main(String[] args) {
		SpringApplication.run(NepheloOssApplication.class, args);
	}
}
