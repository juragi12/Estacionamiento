package co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad;

import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.excepcion.EstacionamientoExcepcion;

public class VehiculoFactory extends EntidadFactory {
	
	@Override
	public Vehiculo getVehiculo(String tipoVehiculo) {
		
		if ( tipoVehiculo.equals(MOTO) ) {
			return new Moto();
		}
		
		if ( tipoVehiculo.equals(CARRO) ) {
			return new Carro();
		}
		
		throw EstacionamientoExcepcion.TIPO_VEHICULO_NO_DEFINIDO.toException();
	}

}
