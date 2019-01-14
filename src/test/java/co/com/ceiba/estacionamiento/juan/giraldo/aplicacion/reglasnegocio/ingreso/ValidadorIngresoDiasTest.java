package co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.reglasnegocio.ingreso;

import static org.junit.Assert.*;

import org.junit.Test;

import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad.vehiculo.Vehiculo;
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
		
		// Act
		boolean ingresoValido = validadorIngresoDias.validarIngreso(vehiculo);

		// Assert
		assertFalse( ingresoValido );

	}

}
