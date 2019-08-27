package com.nephelo.center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class NepheloCenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(NepheloCenterApplication.class, args);
	}
}
