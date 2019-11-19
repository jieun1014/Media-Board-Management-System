package com.transfer.video.vtms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class VtmsApplication {
	public static void main(String[] args) {
		SpringApplication.run(VtmsApplication.class, args);
	}
}
