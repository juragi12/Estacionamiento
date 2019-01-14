package co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.reglasnegocio.ingreso;

import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad.vehiculo.Vehiculo;

public class ValidadorIngresoDias implements ValidadorIngresoVehiculo {

	public static final char RESTRICCION_PLACA = 'A' ;
	public static final int POSICION_LETRA_RESTRICCION_PLACA = 0 ;	
	
	@Override
	public Boolean validarIngreso(Vehiculo vehiculo) {
		
		String placa = vehiculo.getPlaca();
		char letraPlaca = placa.charAt(POSICION_LETRA_RESTRICCION_PLACA);		
		return letraPlaca != RESTRICCION_PLACA;
	}

}
