package co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad;

import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad.vehiculo.FactoryVehiculo;

public class ProcutorFactory {

	public static final String TIPO_FABRICA_VEHICULO = "VEHICULO";
	public static final String TIPO_FABRICA_SITIO_PARQUEO = "SITIO PARQUEO";
		
	public static AbstractFactory getFactory(String factoryTipo) {
		
		if (factoryTipo.equals(TIPO_FABRICA_VEHICULO)) {
			return new FactoryVehiculo(); 
		}
		
		throw new IllegalArgumentException("No se especifico un tipo de fabrica correcto");
		
	}
}
