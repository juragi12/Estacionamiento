package co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.reglasnegocio.salida;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.helper.TiempoEstadia;


/*
 * Prueba que cada uno de los contextos es creados
 */
public class ContextSalidaVehiculoTest {
	
	private int dias = 1;
	private int horas = 1;
	private int PRECIO_A_PAGAR = 0;

	@Test
	public void testContextoCalcularPrecioAPagarMotoAltoCC() {
		
		// Arrange
		CalculadorPrecioMotoAltoCC calculadorPrecio = mock(CalculadorPrecioMotoAltoCC.class);
		ContextSalidaVehiculo contextSalidaVehiculo = 
				new ContextSalidaVehiculo(calculadorPrecio);
		
		when(calculadorPrecio.calcularPrecioAPagar(any())).thenReturn(PRECIO_A_PAGAR);
		TiempoEstadia tiempoEstadia = new TiempoEstadia(dias, horas);
		
		// Act
		int precioAPagar = contextSalidaVehiculo.calcularPrecioAPagar(tiempoEstadia);

		// Assert
		assertTrue( precioAPagar == PRECIO_A_PAGAR );
	}

	@Test
	public void testContextoCalcularPrecioAPagarMotoBajoCC() {
		
		// Arrange
		CalculadorPrecioMotoBajoCC calculadorPrecio = mock(CalculadorPrecioMotoBajoCC.class);
		ContextSalidaVehiculo contextSalidaVehiculo = 
				new ContextSalidaVehiculo(calculadorPrecio);
		
		when(calculadorPrecio.calcularPrecioAPagar(any())).thenReturn(PRECIO_A_PAGAR);
		TiempoEstadia tiempoEstadia = new TiempoEstadia(dias, horas);
		
		// Act
		int precioAPagar = contextSalidaVehiculo.calcularPrecioAPagar(tiempoEstadia);

		// Assert
		assertTrue( precioAPagar == PRECIO_A_PAGAR );
	}
	
	@Test
	public void testContextoCalcularPrecioAPagaCarro() {
		
		// Arrange
		CalculadorPrecioCarro calculadorPrecio = mock(CalculadorPrecioCarro.class);
		ContextSalidaVehiculo contextSalidaVehiculo = 
				new ContextSalidaVehiculo(calculadorPrecio);
		
		when(calculadorPrecio.calcularPrecioAPagar(any())).thenReturn(PRECIO_A_PAGAR);
		TiempoEstadia tiempoEstadia = new TiempoEstadia(dias, horas);
		
		// Act
		int precioAPagar = contextSalidaVehiculo.calcularPrecioAPagar(tiempoEstadia);

		// Assert
		assertTrue( precioAPagar == PRECIO_A_PAGAR );
	}
}
