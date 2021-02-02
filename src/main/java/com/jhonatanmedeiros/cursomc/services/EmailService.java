package com.jhonatanmedeiros.cursomc.services;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;

import com.jhonatanmedeiros.cursomc.domain.Pedido;

public interface EmailService {
	
	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
	
	//Versão HTML
	void sendOrderConfirmationHtmlEmail (Pedido obj);
	
	// Versão HTML
	void sendHtmlEmail(MimeMessage msg);
}
