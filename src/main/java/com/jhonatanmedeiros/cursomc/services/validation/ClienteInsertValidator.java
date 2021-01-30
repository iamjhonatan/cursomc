package com.jhonatanmedeiros.cursomc.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.jhonatanmedeiros.cursomc.domain.Cliente;
import com.jhonatanmedeiros.cursomc.domain.enums.TipoCliente;
import com.jhonatanmedeiros.cursomc.dto.ClienteNewDTO;
import com.jhonatanmedeiros.cursomc.repositories.ClienteRepository;
import com.jhonatanmedeiros.cursomc.resources.exception.FieldMessage;
import com.jhonatanmedeiros.cursomc.services.validation.utils.BR;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {
	
	@Autowired
	private ClienteRepository repo;
	
	@Override
	public void initialize(ClienteInsert ann) {

	}

	@Override
	public boolean isValid(ClienteNewDTO objDTO, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();
		
		if (objDTO.getTipo().equals(TipoCliente.PESSOAFISICA.getCod()) && !BR.isValidCPF(objDTO.getCpfOuCnpj())) {
			list.add(new FieldMessage ("cpfOuCnpj", "CPF inválido."));
		}
			
		if (objDTO.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCod()) && !BR.isValidCNPJ(objDTO.getCpfOuCnpj())) {
			list.add(new FieldMessage ("cpfOuCnpj", "CNPJ inválido."));
		}
		
		Cliente aux = repo.findByEmail(objDTO.getEmail());
		if (aux != null) {
			list.add(new FieldMessage ("email", "E-mail já existente."));
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
