package com.angelalfaro.kinalapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication
public class KinalRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(KinalRestApplication.class, args);
	}

}
