package co.com.ceiba.estacionamiento.juan.giraldo.integracion.aplicacion.reglasnegocio.ingreso;

import static org.junit.Assert.*;

import org.junit.Test;

import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad.Vehiculo;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.reglasnegocio.ingreso.ContextoIngresoVehiculo;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.reglasnegocio.ingreso.ValidadorIngresoDias;
import databuilder.VehiculoDataBuilder;

public class ContextoIngresoVehiculoTest {

	@Test
	public void testContextoValidarIngresoDias() {
		
		// Arrange
		ValidadorIngresoDias validadorIngresoDias = new ValidadorIngresoDias();
		ContextoIngresoVehiculo contextoIngresoVehiculo = new ContextoIngresoVehiculo(validadorIngresoDias);
			
		Vehiculo vehiculo = new VehiculoDataBuilder().buildVehiculo();
		
		// Act
		boolean ingresoValido = contextoIngresoVehiculo.validaIngreso(vehiculo);

		// Assert
		assertTrue(ingresoValido);

	}

}
