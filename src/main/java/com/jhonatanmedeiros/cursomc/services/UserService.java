package com.jhonatanmedeiros.cursomc.services;

import org.springframework.security.core.context.SecurityContextHolder;

import com.jhonatanmedeiros.cursomc.security.UserSS;

public class UserService {
	
	public static UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal(); // métododo Spring Security que retorna o usuário logado
		}
		catch (Exception e) {
			return null;
		}
	}

}
