package co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.reglasnegocio.ingreso;

import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad.vehiculo.Vehiculo;

public class ContextEntradaVehiculo {

	private ValidadorIngresoVehiculo validadorIngresoVehiculo;

	public ContextEntradaVehiculo(ValidadorIngresoVehiculo validadorIngresoVehiculo ) {

		this.validadorIngresoVehiculo = validadorIngresoVehiculo;
	}
	
	public Boolean validaIngreso(Vehiculo vehiculo) {
		return validadorIngresoVehiculo.validaIngreso(vehiculo);
	}

}
