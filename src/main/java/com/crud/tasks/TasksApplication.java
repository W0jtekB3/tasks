package com.crud.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TasksApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(TasksApplication.class);

	public static void main(String[] args) {
		LOGGER.info("Starting my test application!!!");

		// Log a warning about missing configuration fields
		LOGGER.warn("There is missing field in my configuration!!!");

		// Log an error with a custom exception
		try {
			throw new Exception("Configuration is not provided!!!");
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}

		SpringApplication.run(TasksApplication.class, args);
	}
}