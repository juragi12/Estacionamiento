package co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.adaptador;

import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad.vehiculo.Vehiculo;
import co.com.ceiba.estacionamiento.juan.giraldo.persistencia.entidad.VehiculoEntidad;

public class VehiculoAdapter {

	public static Vehiculo getVehiculo(VehiculoEntidad vehiculoEntidad) {
		return new Vehiculo(
				vehiculoEntidad.getPlaca(), 
				vehiculoEntidad.getCilindraje(), 
				vehiculoEntidad.getTipo() 
				);
	} 
}
