package com.wd7.sso;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.cjs.example")
@SpringBootApplication
public class ApplicationSso {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationSso.class, args);
	}
}
