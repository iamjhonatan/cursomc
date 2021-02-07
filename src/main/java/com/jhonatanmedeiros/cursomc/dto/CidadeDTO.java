package com.jhonatanmedeiros.cursomc.dto;

import java.io.Serializable;

import com.jhonatanmedeiros.cursomc.domain.Cidade;
import com.jhonatanmedeiros.cursomc.services.validation.ClienteUpdate;

@ClienteUpdate
public class CidadeDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	
	public CidadeDTO() {
		
	}
	
	public CidadeDTO(Cidade obj) {
		id = obj.getId();
		nome = obj.getNome();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
