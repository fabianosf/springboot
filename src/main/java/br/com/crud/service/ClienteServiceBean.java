package br.com.crud.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.crud.model.Cliente;
import br.com.crud.repository.ClienteRepository;

@Service
public class ClienteServiceBean implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public Cliente findOne(Long id) {
		Cliente cliente = clienteRepository.findOne(id);
		return cliente;
	}

	@Override
	public Cliente create(Cliente cliente) {
		if (cliente.getId() != null) {
			return null;
		}
		Cliente saveCliente = clienteRepository.save(cliente);
		return saveCliente;
	}

	@Override
	public Cliente update(Cliente cliente) {
		Cliente clienteUpdate = findOne(cliente.getId());
		if (clienteUpdate == null) {
			return null;
		}
		Cliente updateCliente = clienteRepository.save(cliente);
		return updateCliente;
	}

	@Override
	public void delete(Long id) {
		clienteRepository.delete(id);
	}

	@Override
	public List<Cliente> findAll() {
		return (List<Cliente>) clienteRepository.findAll();
	}

}
