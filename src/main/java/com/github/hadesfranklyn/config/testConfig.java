package com.github.hadesfranklyn.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.github.hadesfranklyn.services.DBService;

@Configuration
@Profile("test")
public class testConfig {

	@Autowired
	private DBService dbService;

	@Bean
	public boolean instantieteDatabase() throws ParseException {

		dbService.instantieteTestDatabase();
		return true;
	}

}
