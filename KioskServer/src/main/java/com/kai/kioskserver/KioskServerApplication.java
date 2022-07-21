package com.kai.kioskserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KioskServerApplication {

	public static void main(String[] args) {
		// System.setProperty("spring.devtools.restart.enabled", "false");
		// System.setProperty("spring.devtools.restart.livereload.enabled", "true");
		//
		SpringApplication.run(KioskServerApplication.class, args);
	}

}
