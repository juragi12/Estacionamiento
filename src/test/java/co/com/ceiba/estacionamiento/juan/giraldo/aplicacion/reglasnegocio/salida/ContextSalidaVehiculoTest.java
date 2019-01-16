package co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.reglasnegocio.salida;

import static org.junit.Assert.*;

import org.junit.Test;

import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.helper.TiempoEstadia;


/*
 * Prueba que cada uno de los contextos (Formas de calcular los precios al salir el vehiulo)
 */
public class ContextSalidaVehiculoTest {
	
	private int dias = 1;
	private int horas = 1;

	@Test
	public void testContextoCalcularPrecioAPagarMotoAltoCC() {
		
		// Arrange
		int precioAPagarMotoAltoCC = 6500;
		
		CalculadorPrecioMotoAltoCC calculadorPrecio = new CalculadorPrecioMotoAltoCC();
		ContextSalidaVehiculo contextSalidaVehiculo = 
				new ContextSalidaVehiculo(calculadorPrecio);
		
		TiempoEstadia tiempoEstadia = new TiempoEstadia(dias, horas);
	
		// Act
		int precioAPagar = contextSalidaVehiculo.calcularPrecioAPagar(tiempoEstadia);

		// Assert
		assertTrue( precioAPagar == precioAPagarMotoAltoCC );
	}

	@Test
	public void testContextoCalcularPrecioAPagarMotoBajoCC() {
		
		// Arrange
		int precioAPagarMotoBajoCC = 4500;
		
		CalculadorPrecioMotoBajoCC calculadorPrecio = new CalculadorPrecioMotoBajoCC();
		ContextSalidaVehiculo contextSalidaVehiculo = 
				new ContextSalidaVehiculo(calculadorPrecio);
		
		TiempoEstadia tiempoEstadia = new TiempoEstadia(dias, horas);
		
		// Act
		int precioAPagar = contextSalidaVehiculo.calcularPrecioAPagar(tiempoEstadia);

		// Assert
		assertTrue( precioAPagar == precioAPagarMotoBajoCC );
	}
	
	@Test
	public void testContextoCalcularPrecioAPagaCarro() {
		
		// Arrange
		int precioAPagarMotoBajoCC = 9000;
		
		CalculadorPrecioCarro calculadorPrecio = new CalculadorPrecioCarro();
		ContextSalidaVehiculo contextSalidaVehiculo = 
				new ContextSalidaVehiculo(calculadorPrecio);
		
		TiempoEstadia tiempoEstadia = new TiempoEstadia(dias, horas);
		
		// Act
		int precioAPagar = contextSalidaVehiculo.calcularPrecioAPagar(tiempoEstadia);

		// Assert
		assertTrue( precioAPagar == precioAPagarMotoBajoCC );
	}
}
