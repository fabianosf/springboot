/*
 * O método main usa o metodo SpringApplication.run() do SpringBoot para iniciar um aplicativo
 * O CommandLineRunner é uma interface que é usado para executar um codigo após o inicio do aplicativo.
 * 
 */
package br.com.crud;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import br.com.crud.model.Cliente;
import br.com.crud.repository.ClienteRepository;
/**
 * 
 * @author: <a href="mailto:fabiano.freitas@gmail.com">Fabiano Freitas</a> 
 * github: fabiansf
 * 
 *
 */
@SpringBootApplication
public class Application implements CommandLineRunner{
	
	@Autowired
	ClienteRepository clienteRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {		
		Cliente cli1 = new Cliente(null, "Maria Flores", 27);
		Cliente cli2 = new Cliente(null, "Pedro Rocha", 45);
		Cliente cli3 = new Cliente(null, "Joana Leite", 41);		
		//criando uma lista automatica
		clienteRepository.save(Arrays.asList(cli1,cli2,cli3));		
		
	}
}
