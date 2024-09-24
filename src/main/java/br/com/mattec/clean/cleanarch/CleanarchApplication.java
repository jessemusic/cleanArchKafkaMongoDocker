package br.com.mattec.clean.cleanarch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication(scanBasePackages = "br.com.mattec.clean.cleanarch")
public class CleanarchApplication {

	public static void main(String[] args) {
		SpringApplication.run(CleanarchApplication.class, args);
	}

}
