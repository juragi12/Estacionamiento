package co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.reglasnegocio.ingreso;

import java.util.Calendar;
import java.util.Date;

import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad.vehiculo.Vehiculo;

public class ValidadorIngresoDias implements ValidadorIngresoVehiculo {

	public static final char RESTRICCION_PLACA = 'A' ;
	public static final int POSICION_LETRA_RESTRICCION_PLACA = 0 ;	
	
	private Date fechaActual;
	private Calendar calendar;
	
	public ValidadorIngresoDias() {
		fechaActual = new Date();
		calendar = Calendar.getInstance();
		calendar.setTime(fechaActual);
	}
	
	public void setFechaActual(Date fechaActual) {
		this.fechaActual = fechaActual;
		calendar = Calendar.getInstance();
		calendar.setTime(fechaActual);
	}
	
	@Override
	public Boolean validarIngreso(Vehiculo vehiculo) {
		
		// Si primera letra de placa NO es A permite Ingreso
		String placa = vehiculo.getPlaca().toUpperCase();
		char letraPlaca = placa.charAt(POSICION_LETRA_RESTRICCION_PLACA);	
		if ( letraPlaca != RESTRICCION_PLACA ) {		
			return true;
		}
		
		// Si es domingo o lunes permite Ingreso 
		if ( calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ) {
			return true;
		}
		
		return ( calendar.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY );
	}

}
