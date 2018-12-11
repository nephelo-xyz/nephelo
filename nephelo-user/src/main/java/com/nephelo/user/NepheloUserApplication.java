package com.nephelo.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableDiscoveryClient
//@ServletComponentScan("com.xfdmao.fcat.user.config.druid")
public class NepheloUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(NepheloUserApplication.class, args);
	}
}
