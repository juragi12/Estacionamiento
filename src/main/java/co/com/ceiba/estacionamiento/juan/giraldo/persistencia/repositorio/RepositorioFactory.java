package co.com.ceiba.estacionamiento.juan.giraldo.persistencia.repositorio;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class RepositorioFactory {
	
	private RepositorioFactory() {}

	private static final String UNIDAD_PERSISTENCIA = "estacionamiento";
	
	private static EntityManager entityManager = 
			Persistence.createEntityManagerFactory(UNIDAD_PERSISTENCIA).createEntityManager();
	
	public static RepositorioVehiculoImpl obtenerRepositorioVehiculo() {
		return new RepositorioVehiculoImpl(entityManager);
	}
	
	public static RepositorioSitioParqueoImpl obtenerRepositorioSitioParqueo() {
		return new RepositorioSitioParqueoImpl(entityManager);
	}
}
