package co.com.ceiba.estacionamiento.juan.giraldo.unitarias.aplicacion.reglasnegocio.salida;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;

import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.helper.TiempoEstadia;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.reglasnegocio.salida.CalculadorPrecioMotoBajoCC;

public class CalculadorPrecioMotoBajoCCTest {

	int dias;
	int horas;
	int precio;			 
	CalculadorPrecioMotoBajoCC calculadorPrecioMotoBajoCC;
	
	@Before
	public void init() {

		calculadorPrecioMotoBajoCC = new CalculadorPrecioMotoBajoCC();
		dias = 1;
		horas = 1;
		precio = calculadorPrecioMotoBajoCC.getPrecioDia()*dias + 
				calculadorPrecioMotoBajoCC.getPrecioHora()*horas;		
	}

	
	@Test
	public void testCalcularPrecioAPagar() {
		
		// Arrange	
		TiempoEstadia tiempoEstadia = mock(TiempoEstadia.class);
		
		doReturn(dias).when(tiempoEstadia).getDias();
		doReturn(horas).when(tiempoEstadia).getHoras();
		
		
		// Act
		int precioAPagar = calculadorPrecioMotoBajoCC.calcularPrecioAPagar(tiempoEstadia);
		
		// Assert
		assertTrue( precioAPagar == precio );
	}

}
