package com.example.wallet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.example.bean")
@SpringBootApplication
public class PayWalletRest1Application {

	public static void main(String[] args) {
		SpringApplication.run(PayWalletRest1Application.class, args);
	}

}
