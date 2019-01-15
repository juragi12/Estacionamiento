package co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.reglasnegocio;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.doReturn;

import org.junit.Test;

import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad.vehiculo.Vehiculo;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.helper.TiempoEstadia;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.reglasnegocio.ingreso.ContextoIngresoVehiculo;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.reglasnegocio.salida.ContextSalidaVehiculo;
import databuilder.VehiculoDataBuilder;

public class ReglaEstacionamientoTest {
		
	@Test
	public void testValidarIngreso() {
		
		// Arrange
		Vehiculo vehiculo = new VehiculoDataBuilder().buildVehiculo();
		ContextoIngresoVehiculo ctxValidaEntradaVeh = mock(ContextoIngresoVehiculo.class);
		doReturn(true).when(ctxValidaEntradaVeh).validaIngreso(vehiculo);
		
		// Act
		boolean ingresoValido = ReglaEstacionamiento.validarIngreso(vehiculo);
		
		// Assert
		assertTrue(ingresoValido);		

	}

	/*
	 *  Está probando todo el metodo, hay errores de compatibilidad al intentar hacer con 
	 *  powermokito la injeccion del mtodo estatico
	 */
	@Test
	public void testCalcularPrecioParqueo() {
		
		int dias = 1;
		int horas = 1;
		int precio = 6500;
		
		// Arrange
		Vehiculo vehiculo = new VehiculoDataBuilder().buildVehiculo();
		ContextSalidaVehiculo ctxValidaSalidaVeh = mock(ContextSalidaVehiculo.class);
		
		TiempoEstadia tiempoEstadia = mock(TiempoEstadia.class);
		doReturn(dias).when(tiempoEstadia).getDias();
		doReturn(horas).when(tiempoEstadia).getHoras();
		
		doReturn(precio).when(ctxValidaSalidaVeh).calcularPrecioAPagar(tiempoEstadia);
		
		// Act
		int precioAPagar = ReglaEstacionamiento.calcularPrecioParqueo(vehiculo, tiempoEstadia);

		// Assert
		assertEquals(precio, precioAPagar);
				
	}

}
