package com.auca.onlineappaertmentreservistionbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class OnlineAppaertmentReservistionBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineAppaertmentReservistionBookApplication.class, args);
	}

}
