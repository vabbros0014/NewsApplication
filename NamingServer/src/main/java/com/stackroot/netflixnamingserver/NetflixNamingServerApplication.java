package com.stackroot.netflixnamingserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer
public class NetflixNamingServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetflixNamingServerApplication.class, args);
	}

}
