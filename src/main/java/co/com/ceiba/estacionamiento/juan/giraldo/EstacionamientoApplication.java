package co.com.ceiba.estacionamiento.juan.giraldo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("co.com.ceiba.estacionamiento.juan.giraldo.persistencia.repositorio") 
@EntityScan("co.com.ceiba.estacionamiento.juan.giraldo.persistencia.entidad")
@SpringBootApplication
public class EstacionamientoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstacionamientoApplication.class, args);
	}

}

