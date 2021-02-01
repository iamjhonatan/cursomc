package com.jhonatanmedeiros.cursomc.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.jhonatanmedeiros.cursomc.services.DBService;
import com.jhonatanmedeiros.cursomc.services.EmailService;
import com.jhonatanmedeiros.cursomc.services.MockEmailService;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	private DBService dbService;
	
	@Bean
	public boolean instantiateDatabase() throws ParseException {
		dbService.instantiateTestDatabase();
		
		return true;
	}
	
	// Quando um método com a anotação '@Bean' é criado, ele está disponível como um componente no sistema. 
	// Se em outra classe houver uma injeção de dependência, como foi feito no 'PedidoService', o Spring procura por um componente, que pode ser um '@Bean', e retorna uma nova instância que está no método. 
	@Bean
	public EmailService emailService() {
		return new MockEmailService();
	}

}
