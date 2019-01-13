package co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.repositorio;

import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad.vehiculo.Vehiculo;
import co.com.ceiba.estacionamiento.juan.giraldo.persistencia.entidad.VehiculoEntidad;

public interface RepositorioVehiculo {

	/* 
	 * Agrega un vehiculo al repositorio
	 */
	VehiculoEntidad guardar(Vehiculo vehiculo);
}
