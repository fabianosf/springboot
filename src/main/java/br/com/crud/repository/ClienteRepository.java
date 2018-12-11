package br.com.crud.repository;
import org.springframework.data.repository.CrudRepository;
import br.com.crud.model.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {	

}
