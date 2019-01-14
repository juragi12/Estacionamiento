package co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.reglasnegocio.ingreso;

import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad.vehiculo.Vehiculo;

public class ContextoIngresoVehiculo {

	private ValidadorIngresoVehiculo validadorIngresoVehiculo;

	public ContextoIngresoVehiculo(ValidadorIngresoVehiculo validadorIngresoVehiculo ) {

		this.validadorIngresoVehiculo = validadorIngresoVehiculo;
	}
	
	public Boolean validaIngreso(Vehiculo vehiculo) {
		return validadorIngresoVehiculo.validarIngreso(vehiculo);
	}

}
