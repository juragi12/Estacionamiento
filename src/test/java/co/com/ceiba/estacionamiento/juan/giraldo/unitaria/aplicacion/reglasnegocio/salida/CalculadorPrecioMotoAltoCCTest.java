package co.com.ceiba.estacionamiento.juan.giraldo.unitaria.aplicacion.reglasnegocio.salida;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.doReturn;

import org.junit.Before;
import org.junit.Test;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.helper.TiempoEstadia;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.reglasnegocio.salida.CalculadorPrecioMotoAltoCC;


public class CalculadorPrecioMotoAltoCCTest {

	int dias;
	int horas;
	int precio;			 
	CalculadorPrecioMotoAltoCC calculadorPrecioMotoAltoCC;
	
	@Before
	public void init() {

		calculadorPrecioMotoAltoCC = new CalculadorPrecioMotoAltoCC();
		dias = 1;
		horas = 1;
		precio = calculadorPrecioMotoAltoCC.getPrecioDia()*dias + 
				calculadorPrecioMotoAltoCC.getPrecioHora()*horas + 
				calculadorPrecioMotoAltoCC.getRecargo();			
	}

	
	@Test
	public void testCalcularPrecioAPagar() {
		
		// Arrange	
		TiempoEstadia tiempoEstadia = mock(TiempoEstadia.class);
		
		doReturn(dias).when(tiempoEstadia).getDias();
		doReturn(horas).when(tiempoEstadia).getHoras();
		
		
		// Act
		int precioAPagar = calculadorPrecioMotoAltoCC.calcularPrecioAPagar(tiempoEstadia);
		
		// Assert
		assertTrue( precioAPagar == precio );
	}

}
