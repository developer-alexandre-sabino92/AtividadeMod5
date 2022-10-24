package com.example.services.impl;

import java.util.Optional;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.ErroAutenticacao;
import com.example.exception.RegraNegocioException;
import com.example.model.entity.Cliente;
import com.example.repositories.ClienteRepository;
import com.example.services.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteRepository repository;

	@Override
	public Cliente autenticar(String email, String senha) {
		Optional<Cliente> cliente = repository.findByEmail(email);
		
		if(!cliente.isPresent()) {
			
			throw new ErroAutenticacao("Usuario não encontrado.");
		}
		if(!cliente.get().getSenha().equals(senha)) {
			
			throw new ErroAutenticacao("Senha Incorreta.");
			
		}
		return cliente.get();
	}

	@Override
	@Transactional
	public Cliente salvarCliente(Cliente cliente) {
		validarEmail(cliente.getEmail());
		return repository.save(cliente);
	}

	@Override
	public void validarEmail(String email) {
		boolean existe = repository.existsByEmail(email);
		if (existe) {
			
			throw new RegraNegocioException("Já existe um cliente cadastrado com esse email.");
		}
		
	}

	@Override
	public Optional<Cliente> buscarPorId(Long id) {
		
		return repository.findById(id);
	}

}
