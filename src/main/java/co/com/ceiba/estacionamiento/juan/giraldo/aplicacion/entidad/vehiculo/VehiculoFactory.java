package co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad.vehiculo;

import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad.EntidadFactory;

public class VehiculoFactory extends EntidadFactory {
	
	@Override
	public Vehiculo getVehiculo(String tipoVehiculo) {
		
		if ( tipoVehiculo.equals(MOTO) ) return new Moto();
		
		if ( tipoVehiculo.equals(CARRO) ) return new Carro();
		
		throw new IllegalArgumentException("No se especifico un tipo de vehiculo correcto");
	}

}
