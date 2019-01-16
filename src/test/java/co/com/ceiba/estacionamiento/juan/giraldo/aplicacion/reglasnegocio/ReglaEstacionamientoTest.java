package co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.reglasnegocio;

import static org.junit.Assert.*;

import org.junit.Test;

import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad.vehiculo.Vehiculo;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.helper.TiempoEstadia;
import databuilder.VehiculoDataBuilder;

public class ReglaEstacionamientoTest {
		
	@Test
	public void testValidarIngreso() {
		
		// Arrange
		Vehiculo vehiculo = new VehiculoDataBuilder().buildVehiculo();
//		ContextoIngresoVehiculo ctxValidaEntradaVeh = mock(ContextoIngresoVehiculo.class);
//		doReturn(true).when(ctxValidaEntradaVeh).validaIngreso(vehiculo);
		
		// Act
		boolean ingresoValido = ReglaEstacionamiento.validarIngreso(vehiculo);
		
		// Assert
		assertTrue(ingresoValido);		

	}
	
	@Test
	public void testCalcularPrecioParqueo() {
		
		int dias = 1;
		int horas = 1;
		int precio = 4500;
		
		// Arrange
		Vehiculo vehiculoMotoBahoCC = new VehiculoDataBuilder().buildVehiculo();
		TiempoEstadia tiempoEstadia = new TiempoEstadia(dias, horas);
		
//		ContextSalidaVehiculo ctxValidaSalidaVeh = mock(ContextSalidaVehiculo.class);
//		TiempoEstadia tiempoEstadia = mock(TiempoEstadia.class);
//		doReturn(dias).when(tiempoEstadia).getDias();
//		doReturn(horas).when(tiempoEstadia).getHoras();
//		doReturn(precio).when(ctxValidaSalidaVeh).calcularPrecioAPagar(tiempoEstadia);
		
		// Act
		int precioAPagar = ReglaEstacionamiento.calcularPrecioParqueo(vehiculoMotoBahoCC, tiempoEstadia);

		// Assert
		assertEquals(precio, precioAPagar);
				
	}

}
