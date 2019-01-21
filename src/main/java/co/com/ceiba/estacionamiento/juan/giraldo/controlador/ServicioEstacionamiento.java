package co.com.ceiba.estacionamiento.juan.giraldo.controlador;

import java.util.List;

import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad.vehiculo.Vehiculo;
import co.com.ceiba.estacionamiento.juan.giraldo.persistencia.entidad.SitioParqueoEntidad;

public interface ServicioEstacionamiento {

	/*
	 * Registra en el estacionamiento el ingreso de un vehiculo
	 */
	SitioParqueoEntidad registrarIngresoVehiculo(Vehiculo vehiculo);
	
	/*
	 * Registra la salida de un vehiculo y devuelve el precio a pagar
	 */
	int registrarSalidaVehiculo(Vehiculo vehiculo);
	
	/*
	 * Devuelve la lista de vehiculos estacionados
	 */
	List<Object> consultarVehiculos();
}
