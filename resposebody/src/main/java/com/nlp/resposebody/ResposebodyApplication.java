package com.nlp.resposebody;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class ResposebodyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResposebodyApplication.class, args);
	}

}
