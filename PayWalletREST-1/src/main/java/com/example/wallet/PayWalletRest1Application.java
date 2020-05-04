package com.example.wallet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"com.example.wallet.bean"})
@SpringBootApplication
public class PayWalletRest1Application {

	public static void main(String[] args) {
		SpringApplication.run(PayWalletRest1Application.class, args);
	}

}
