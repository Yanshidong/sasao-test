package com.cjs.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.cjs.example")
@SpringBootApplication
public class CjsOauth2CodeServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CjsOauth2CodeServerApplication.class, args);
	}
}
