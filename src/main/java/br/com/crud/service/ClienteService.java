package br.com.crud.service;

import java.util.List;

import br.com.crud.model.Cliente;

public interface ClienteService {
	
	List<Cliente>findAll();
	Cliente findOne(Long id);
	Cliente create(Cliente cliente);
	Cliente update(Cliente cliente);
	void delete(Long id);

}
