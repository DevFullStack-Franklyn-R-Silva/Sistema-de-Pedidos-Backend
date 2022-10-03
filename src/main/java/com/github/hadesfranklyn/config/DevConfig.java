package com.github.hadesfranklyn.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.github.hadesfranklyn.services.DBService;
import com.github.hadesfranklyn.services.EmailService;
import com.github.hadesfranklyn.services.SmtpEmailService;

@Configuration
@Profile("dev")
public class DevConfig {

	@Autowired
	private DBService dbService;

	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;

	@Bean
	public boolean instantieteDatabase() throws ParseException {
		if (!"create".equals(strategy)) {
			return false;
		}
		dbService.instantieteTestDatabase();
		return true;
	}
	
	// Problema de enviar email resolvido
	// https://stackoverflow.com/questions/26594097/javamail-exception-javax-mail-authenticationfailedexception-534-5-7-9-applicatio
	@Bean
	public EmailService emailService() {
		return new SmtpEmailService();
	}
}
