package br.com.crud.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.crud.model.Cliente;
import br.com.crud.service.ClienteService;

@RestController
@RequestMapping(value = "/api")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	
	@RequestMapping(value = "/clientes", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Cliente>> getClientes(){
		Collection<Cliente> clientes = clienteService.findAll();
		return new ResponseEntity<Collection<Cliente>>(clientes, HttpStatus.OK);
	}
	 
	@RequestMapping(value="/cliente/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> getCliente(@PathVariable("id")Long id){
		Cliente cliente = clienteService.findOne(id);
		if(cliente == null) {
			return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/clientes", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente){
		Cliente saveCliente = clienteService.create(cliente);
		return new ResponseEntity<Cliente>(saveCliente, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/clientes/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> updateCliente(@PathVariable("id")Long id, @RequestBody Cliente cliente){
		Cliente updateCliente = null;
		if(cliente != null && id == cliente.getId()) {
			updateCliente = clienteService.update(cliente);
		}
		if(updateCliente == null) {
			return new ResponseEntity<Cliente>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Cliente>(updateCliente, HttpStatus.OK);
	}
	
	public ResponseEntity<Cliente> deleteCliente(@PathVariable("id") Long id){
		clienteService.delete(id);
		return new ResponseEntity<Cliente>(HttpStatus.NO_CONTENT);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
