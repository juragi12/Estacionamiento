package co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.reglasnegocio.ingreso;

import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad.vehiculo.Vehiculo;

public class ValidadorIngresoDias implements ValidadorIngresoVehiculo {

	public static final char RESTRICCION = 'A' ;
	@Override
	public Boolean validaIngreso(Vehiculo vehiculo) {
		
		String placa = vehiculo.getPlaca();
		char primeraLetraPlaca = placa.charAt(0);		
		return primeraLetraPlaca != RESTRICCION;
	}

}
