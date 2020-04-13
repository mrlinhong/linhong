package com.linhong;

import org.redisson.Redisson;
import org.redisson.config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class LinhongApplication {

	public static void main(String[] args) {
		SpringApplication.run(LinhongApplication.class, args);
	}

	@Bean
	public Redisson redisson(){

		// 此配置为单机模式
		Config config = new Config();
		config.useSingleServer().setAddress("redis://127.0.0.1:6379").setDatabase(8);
		return (Redisson) Redisson.create(config);

	}

}
