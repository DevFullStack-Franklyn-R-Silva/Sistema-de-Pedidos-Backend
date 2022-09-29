package com.github.hadesfranklyn.services;

import org.springframework.mail.SimpleMailMessage;

import com.github.hadesfranklyn.domain.Pedido;

public interface EmailService {

	// email de confirmação de pedido
	void sendOrderConfirmationEmail(Pedido obj);
	
	// enviar email
	void sendEmail(SimpleMailMessage msg);
}
