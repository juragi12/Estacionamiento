package co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad;


public abstract class EntidadFactory {
	
	public static final String MOTO = "MOTO";
	public static final String CARRO = "CARRO";

	public abstract Vehiculo getVehiculo(String tipo);
}
