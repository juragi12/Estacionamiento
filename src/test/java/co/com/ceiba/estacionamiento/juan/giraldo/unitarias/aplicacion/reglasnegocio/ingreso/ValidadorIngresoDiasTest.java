package co.com.ceiba.estacionamiento.juan.giraldo.unitarias.aplicacion.reglasnegocio.ingreso;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad.Vehiculo;
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
	public void testValidaIngresoVehiculoRestringidoDiaViernesNOIngresa() {

		// Arrange
		Calendar calendar = Calendar.getInstance();
		calendar.set(2019,0,18); // Enero 18/2019
		
		boolean ingresoValidoActual;
		ValidadorIngresoDias validadorIngresoDias = new ValidadorIngresoDias();		
		Vehiculo vehiculo = new VehiculoDataBuilder().setPlaca(placaRestringida).buildVehiculo();
		
		validadorIngresoDias.setFechaActual(calendar.getTime());
	
		// Act		
		ingresoValidoActual = validadorIngresoDias.validarIngreso(vehiculo);

		// Assert
		assertFalse( ingresoValidoActual );	

	}
	
	@Test
	public void testValidaIngresoVehiculoRestringidoDiaLunesIngresa() {

		// Arrange
		Calendar calendar = Calendar.getInstance();
		calendar.set(2019,0,21);
		
		boolean ingresoValidoActual;
		ValidadorIngresoDias validadorIngresoDias = new ValidadorIngresoDias();		
		Vehiculo vehiculo = new VehiculoDataBuilder().setPlaca(placaRestringida).buildVehiculo();
		
		validadorIngresoDias.setFechaActual(calendar.getTime());
	
		// Act		
		ingresoValidoActual = validadorIngresoDias.validarIngreso(vehiculo);

		// Assert
		assertTrue( ingresoValidoActual );	

	}
	
	@Test
	public void testValidaIngresoVehiculoRestringidoDiaDomingoIngresa() {

		// Arrange
		Calendar calendar = Calendar.getInstance();
		calendar.set(2019,0,20);
		
		boolean ingresoValidoActual;
		ValidadorIngresoDias validadorIngresoDias = new ValidadorIngresoDias();		
		Vehiculo vehiculo = new VehiculoDataBuilder().setPlaca(placaRestringida).buildVehiculo();
		
		validadorIngresoDias.setFechaActual(calendar.getTime());
	
		// Act		
		ingresoValidoActual = validadorIngresoDias.validarIngreso(vehiculo);

		// Assert
		assertTrue( ingresoValidoActual );	

	}

}
