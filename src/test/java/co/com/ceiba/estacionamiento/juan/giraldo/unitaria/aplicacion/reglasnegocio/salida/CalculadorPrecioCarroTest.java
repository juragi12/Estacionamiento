package co.com.ceiba.estacionamiento.juan.giraldo.unitaria.aplicacion.reglasnegocio.salida;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;

import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.helper.TiempoEstadia;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.reglasnegocio.salida.CalculadorPrecioCarro;

public class CalculadorPrecioCarroTest {

	int dias;
	int horas;
	int precio;			 
	CalculadorPrecioCarro calculadorPrecioCarro;
	
	@Before
	public void init() {

		calculadorPrecioCarro = new CalculadorPrecioCarro();
		dias = 1;
		horas = 1;
		precio = calculadorPrecioCarro.getPrecioDia()*dias + 
				calculadorPrecioCarro.getPrecioHora()*horas;			
	}

	
	@Test
	public void testCalcularPrecioAPagar() {
		// Arrange	
		TiempoEstadia tiempoEstadia = mock(TiempoEstadia.class);
		
		doReturn(dias).when(tiempoEstadia).getDias();
		doReturn(horas).when(tiempoEstadia).getHoras();
		
		
		// Act
		int precioAPagar = calculadorPrecioCarro.calcularPrecioAPagar(tiempoEstadia);
		
		// Assert
		assertTrue( precioAPagar == precio );
	}

}
