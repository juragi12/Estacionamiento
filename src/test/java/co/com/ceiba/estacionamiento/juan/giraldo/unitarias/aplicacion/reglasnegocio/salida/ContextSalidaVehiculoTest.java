package co.com.ceiba.estacionamiento.juan.giraldo.unitarias.aplicacion.reglasnegocio.salida;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.helper.TiempoEstadia;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.reglasnegocio.salida.CalculadorPrecioCarro;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.reglasnegocio.salida.CalculadorPrecioMotoAltoCC;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.reglasnegocio.salida.CalculadorPrecioMotoBajoCC;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.reglasnegocio.salida.ContextSalidaVehiculo;

public class ContextSalidaVehiculoTest {


	private int dias = 1;
	private int horas = 1;
	private int PRECIO_A_PAGAR = 0;
	
	@Mock
	CalculadorPrecioMotoBajoCC calculadorPrecioMotoBajoCC;
	@Mock
	CalculadorPrecioMotoAltoCC calculadorPrecioMotoAltoCC;
	@Mock
	CalculadorPrecioCarro calculadorPrecioCarro;

	
	@InjectMocks
	ContextSalidaVehiculo contextSalidaVehiculo = new ContextSalidaVehiculo();
	
	
	@Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
	

	@Test
	public void testContextoCalcularPrecioAPagarMotoAltoCC() {
		
		// Arrange
		contextSalidaVehiculo.setContextSalidaVehiculo(calculadorPrecioMotoAltoCC);
		
		when(calculadorPrecioMotoAltoCC.calcularPrecioAPagar(any())).thenReturn(PRECIO_A_PAGAR);
		TiempoEstadia tiempoEstadia = new TiempoEstadia(dias, horas);
		
		// Act
		int precioAPagar = contextSalidaVehiculo.calcularPrecioAPagar(tiempoEstadia);

		// Assert
		assertTrue( precioAPagar == PRECIO_A_PAGAR );
	}

	@Test
	public void testContextoCalcularPrecioAPagarMotoBajoCC() {
		
		// Arrange
		contextSalidaVehiculo.setContextSalidaVehiculo(calculadorPrecioMotoBajoCC);
		
		when(calculadorPrecioMotoBajoCC.calcularPrecioAPagar(any())).thenReturn(PRECIO_A_PAGAR);
		TiempoEstadia tiempoEstadia = new TiempoEstadia(dias, horas);
		
		// Act
		int precioAPagar = contextSalidaVehiculo.calcularPrecioAPagar(tiempoEstadia);

		// Assert
		assertTrue( precioAPagar == PRECIO_A_PAGAR );
	}
	
	@Test
	public void testContextoCalcularPrecioAPagaCarro() {
		
		// Arrange
		contextSalidaVehiculo.setContextSalidaVehiculo(calculadorPrecioCarro);
		
		when(calculadorPrecioCarro.calcularPrecioAPagar(any())).thenReturn(PRECIO_A_PAGAR);
		TiempoEstadia tiempoEstadia = new TiempoEstadia(dias, horas);
		
		// Act
		int precioAPagar = contextSalidaVehiculo.calcularPrecioAPagar(tiempoEstadia);

		// Assert
		assertTrue( precioAPagar == PRECIO_A_PAGAR );
	}

}
