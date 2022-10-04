package com.github.hadesfranklyn.services;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;

import com.github.hadesfranklyn.domain.Cliente;
import com.github.hadesfranklyn.domain.Pedido;

public interface EmailService {

	// email de confirmação de pedido
	void sendOrderConfirmationEmail(Pedido obj);
	
	// enviar email
	void sendEmail(SimpleMailMessage msg);
	
	void sendOrderConfirmationHtmlEmail(Pedido obj);
	
	void sendHtmlEmail(MimeMessage msg);
	
	void sendNewPasswordEmail(Cliente cliente, String newPass);
}
