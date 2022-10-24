package com.example.services;

import java.util.Optional;

import com.example.model.entity.Cliente;

public interface ClienteService {
	
	Cliente autenticar (String email,String senha);
	
	Cliente salvarCliente(Cliente cliente);
	
	void validarEmail(String email);
	
	Optional<Cliente> buscarPorId(Long id);
	


}
