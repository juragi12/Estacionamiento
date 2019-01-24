package co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.repositorio;

import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad.Vehiculo;
import co.com.ceiba.estacionamiento.juan.giraldo.persistencia.entidad.VehiculoEntidad;

public interface VehiculoEntidadService {

	VehiculoEntidad guardar(Vehiculo vehiculo);
	
	VehiculoEntidad byPlaca(Vehiculo vehiculo);
	
	void borrar(Vehiculo vehiculo);

}
