package com.evaluacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class EvaluacionApplication {

	public static void main(String[] args) {
		SpringApplication.run(EvaluacionApplication.class, args);
	}

}
