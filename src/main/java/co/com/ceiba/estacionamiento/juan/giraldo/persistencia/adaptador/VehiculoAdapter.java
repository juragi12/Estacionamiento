package co.com.ceiba.estacionamiento.juan.giraldo.persistencia.adaptador;

import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad.Vehiculo;
import co.com.ceiba.estacionamiento.juan.giraldo.persistencia.entidad.VehiculoEntidad;

public final class VehiculoAdapter {
	
	private VehiculoAdapter() {}
	
	public static VehiculoEntidad getVehiculoEntidad(Vehiculo vehiculo) {
		return new VehiculoEntidad(
				vehiculo.getPlaca(), vehiculo.getCilindraje(), vehiculo.getTipo() 
				);
	} 

}
