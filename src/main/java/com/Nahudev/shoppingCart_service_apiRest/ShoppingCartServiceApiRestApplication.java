package com.Nahudev.shoppingCart_service_apiRest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ShoppingCartServiceApiRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingCartServiceApiRestApplication.class, args);
	}

}
