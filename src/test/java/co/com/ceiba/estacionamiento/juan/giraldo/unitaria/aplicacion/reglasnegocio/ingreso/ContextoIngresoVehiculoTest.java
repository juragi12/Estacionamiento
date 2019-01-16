package co.com.ceiba.estacionamiento.juan.giraldo.unitaria.aplicacion.reglasnegocio.ingreso;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad.vehiculo.Vehiculo;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.reglasnegocio.ingreso.ContextoIngresoVehiculo;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.reglasnegocio.ingreso.ValidadorIngresoDias;
import databuilder.VehiculoDataBuilder;

public class ContextoIngresoVehiculoTest {
	
	@Mock
	ValidadorIngresoDias validadorIngresoDias;
	
	@InjectMocks
	ContextoIngresoVehiculo contextoIngresoVehiculo = new ContextoIngresoVehiculo();
	
	@Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void testValidaIngreso() {
		
		// Arrange		
		contextoIngresoVehiculo.setContextoIngresoVehiculo(validadorIngresoDias);
		when(validadorIngresoDias.validarIngreso(any())).thenReturn(true);
		
		Vehiculo vehiculo = new VehiculoDataBuilder().buildVehiculo();
		
		// Act
		boolean ingresoValido = contextoIngresoVehiculo.validaIngreso(vehiculo);

		// Assert
		assertTrue(ingresoValido);
	}

}
