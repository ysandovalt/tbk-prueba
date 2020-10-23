package com.tbk.apisample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DataconnApplication {

	private static final Logger logger = LoggerFactory.getLogger(DataconnApplication.class);

	public static void main(String[] args) {
		logger.info("StartPoint");
		SpringApplication.run(DataconnApplication.class, args);
	}

}
