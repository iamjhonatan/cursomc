package com.jhonatanmedeiros.cursomc.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component
public class HeaderExposureFilter implements Filter {

	// Filtro que intercepta todas as requisições
	// Expondo o cabeçalho 'location' na resposta e encaminha a requisição para o ciclo normal
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletResponse res = (HttpServletResponse) response; // a função 'addHeader' não existe no ServletResponse, apenas no HttpServletResponse, então um cast foi feito
		res.addHeader("access-control-expose-headers", "location");
		chain.doFilter(request, response);
	}

	
}
