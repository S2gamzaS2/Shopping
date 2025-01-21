package org.study.shopping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShoppingApplication {

    public static void main(String[] args) {
        // SpringBoot 웹서버 띄워주삼
        SpringApplication.run(ShoppingApplication.class, args);
    }

}