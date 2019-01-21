package co.com.ceiba.estacionamiento.juan.giraldo.unitaria.aplicacion.reglasnegocio.ingreso;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad.vehiculo.Vehiculo;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.reglasnegocio.ingreso.ValidadorIngresoDias;
import databuilder.VehiculoDataBuilder;

public class ValidadorIngresoDiasTest {
	
	String placaRestringida = "ABC-123";

	@Test
	public void testValidaIngresoVehiculo() {

		// Arrange
		ValidadorIngresoDias validadorIngresoDias = new ValidadorIngresoDias();		
		Vehiculo vehiculo = new VehiculoDataBuilder().buildVehiculo();
		
		// Act
		boolean ingresoValido = validadorIngresoDias.validarIngreso(vehiculo);

		// Assert
		assertTrue( ingresoValido );

	}
	
	@Test
	public void testValidaIngresoVehiculoRestringido() {

		// Arrange
		ValidadorIngresoDias validadorIngresoDias = new ValidadorIngresoDias();		
		Vehiculo vehiculo = new VehiculoDataBuilder().setPlaca(placaRestringida).buildVehiculo();
		
		Date fechaActual = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fechaActual);
		boolean ingresoValido = false;
		
		// Si es domingo o lunes permite Ingreso 
		if ( calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ) ingresoValido = true;		
		if ( calendar.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY ) ingresoValido = true;
		
		// Act
		boolean ingresoValidoActual = validadorIngresoDias.validarIngreso(vehiculo);

		// Assert
		assertTrue( ingresoValido == ingresoValidoActual );

	}

}
