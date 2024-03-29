package co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.adaptador;

import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad.Vehiculo;
import co.com.ceiba.estacionamiento.juan.giraldo.persistencia.entidad.VehiculoEntidad;

public final class VehiculoAdapter {

	private VehiculoAdapter() {}
	
	public static Vehiculo getVehiculo(VehiculoEntidad vehiculoEntidad) {
		return new Vehiculo(
				vehiculoEntidad.getPlaca(), 
				vehiculoEntidad.getCilindraje(), 
				vehiculoEntidad.getTipo() 
				);
	} 
}
