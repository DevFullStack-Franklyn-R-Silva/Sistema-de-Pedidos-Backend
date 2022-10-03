package com.github.hadesfranklyn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.hadesfranklyn.domain.PagamentoComBoleto;
import com.github.hadesfranklyn.domain.PagamentoComCartao;

@Configuration
public class JacksonConfig {
// https://stackoverflow.com/questions/41452598/overcome-can-not-construct-instance-ofinterfaceclass-without-hinting-the-pare
	@Bean
	public Jackson2ObjectMapperBuilder objectMapperBuilder() {
		Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder() {
			public void configure(ObjectMapper objectMapper) {
				objectMapper.registerSubtypes(PagamentoComCartao.class);
				objectMapper.registerSubtypes(PagamentoComBoleto.class);
				super.configure(objectMapper);
			};
		};
		return builder;
	}

	/*
	 * Para corrigir o errp foi adicionado esse metodo JavaMailSender para poder usar o test profile.
	 * A solução mais correta é manter o MockMailService e não o SMTP do profile
	 * DEV. Ou seja, não altere nada no arquivo TestConfig. Ao invés disso, pra
	 * corrigir o problema é simples. Vá no JacksonConfig e acrescente o Bean do
	 * JavaMailSender assim:
	 */
	@Bean
	public JavaMailSender jMS() {
		return new JavaMailSenderImpl();
	}
}