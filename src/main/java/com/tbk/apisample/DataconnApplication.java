package com.tbk.apisample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class DataconnApplication {

	public static void main(String[] args) {
		log.info("Start Point");
		SpringApplication.run(DataconnApplication.class, args);
	}

}
