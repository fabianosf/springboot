package br.com.crud.repository;
 
 

import org.springframework.data.repository.CrudRepository;
import br.com.crud.model.Cliente;

//Aqui herdo todos os metodos do JPA(salvar,excluir, buscar)
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
	
	 

}
