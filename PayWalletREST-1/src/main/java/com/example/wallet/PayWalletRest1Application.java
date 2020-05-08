package com.example.wallet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = {"com.example.wallet.bean"})
@SpringBootApplication
public class PayWalletRest1Application {

	public static void main(String[] args) {
		SpringApplication.run(PayWalletRest1Application.class, args);
	}

}
