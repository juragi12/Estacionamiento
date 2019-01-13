package co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad;

import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad.vehiculo.Vehiculo;

public abstract class AbstractFactory {
	
	public static final String MOTO = "MOTO";
	public static final String CARRO = "CARRO";

	public abstract Vehiculo getVehiculo(String tipo);
}
