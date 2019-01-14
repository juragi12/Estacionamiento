package co.com.ceiba.estacionamiento.juan.giraldo.persistencia.repositorio;

import javax.persistence.EntityManager;

import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad.vehiculo.Vehiculo;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.repositorio.RepositorioVehiculo;
import co.com.ceiba.estacionamiento.juan.giraldo.persistencia.adaptador.VehiculoAdapter;
import co.com.ceiba.estacionamiento.juan.giraldo.persistencia.entidad.VehiculoEntidad;

public class RepositorioVehiculoImpl implements RepositorioVehiculo {

	private EntityManager entityManager;
	
	public RepositorioVehiculoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public VehiculoEntidad guardar(Vehiculo vehiculo) {
		
		VehiculoEntidad vehiculoEntidad = VehiculoAdapter.getVehiculoEntidad(vehiculo);
		
		this.entityManager.getTransaction().begin();		
		this.entityManager.persist(vehiculoEntidad);
		this.entityManager.getTransaction().commit();
		
		return vehiculoEntidad;
	}
}
