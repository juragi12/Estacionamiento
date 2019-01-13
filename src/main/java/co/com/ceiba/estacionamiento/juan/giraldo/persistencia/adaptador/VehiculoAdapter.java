package co.com.ceiba.estacionamiento.juan.giraldo.persistencia.adaptador;

import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad.vehiculo.Vehiculo;
import co.com.ceiba.estacionamiento.juan.giraldo.persistencia.entidad.VehiculoEntidad;

public class VehiculoAdapter {
	
	public static VehiculoEntidad getVehiculoEntidad(Vehiculo vehiculo) {
		return new VehiculoEntidad(
				vehiculo.getPlaca(), vehiculo.getCilindraje(), vehiculo.getTipo() 
				);
	} 

}
