package co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.reglasnegocio.ingreso;

import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad.Vehiculo;

public interface ValidadorIngresoVehiculo {

	/*
	 * Verifica la regla de ingreso para un vehiculo
	 */
	public Boolean validarIngreso(Vehiculo vehiculo);
}
