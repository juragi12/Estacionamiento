package co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad;

import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad.vehiculo.VehiculoFactory;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.excepcion.EstacionamientoExcepcion;

public final class CrearEntidadFactory {

	public static final String TIPO_FABRICA_VEHICULO = "VEHICULO";
	
	private CrearEntidadFactory() {}
		
	public static EntidadFactory getFactory(String factoryTipo) {
		
		if (factoryTipo.equals(TIPO_FABRICA_VEHICULO)) {
			return new VehiculoFactory(); 
		}
		
		throw EstacionamientoExcepcion.TIPO_FABRICA_NO_DEFINIDO.toException();		
	}
}
