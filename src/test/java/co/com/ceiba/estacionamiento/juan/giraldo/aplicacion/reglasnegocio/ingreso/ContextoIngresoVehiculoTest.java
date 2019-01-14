package co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.reglasnegocio.ingreso;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Matchers.any;

import org.junit.Test;

import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad.vehiculo.Vehiculo;
import databuilder.VehiculoDataBuilder;

public class ContextoIngresoVehiculoTest {

	@Test
	public void testContextoValidarIngresoDias() {
		
		// Arrange
		ValidadorIngresoDias validadorIngresoDias = mock(ValidadorIngresoDias.class);
		ContextoIngresoVehiculo contextoIngresoVehiculo = new ContextoIngresoVehiculo(validadorIngresoDias);
					
		when(validadorIngresoDias.validarIngreso(any())).thenReturn(true);
		
		Vehiculo vehiculo = new VehiculoDataBuilder().buildVehiculo();
		
		// Act
		boolean ingresoValido = contextoIngresoVehiculo.validaIngreso(vehiculo);

		// Assert
		assertTrue(ingresoValido);

	}

}
