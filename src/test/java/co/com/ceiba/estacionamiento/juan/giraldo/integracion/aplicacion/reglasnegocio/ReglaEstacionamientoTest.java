package co.com.ceiba.estacionamiento.juan.giraldo.integracion.aplicacion.reglasnegocio;

import static org.junit.Assert.*;

import org.junit.Test;

import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad.vehiculo.Vehiculo;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.helper.TiempoEstadia;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.reglasnegocio.ReglaEstacionamiento;
import databuilder.VehiculoDataBuilder;

public class ReglaEstacionamientoTest {
		
	@Test
	public void testValidarIngreso() {
		
		// Arrange
		Vehiculo vehiculo = new VehiculoDataBuilder().buildVehiculo();
		
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
		
		// Act
		int precioAPagar = ReglaEstacionamiento.calcularPrecioParqueo(vehiculoMotoBahoCC, tiempoEstadia);

		// Assert
		assertEquals(precio, precioAPagar);
				
	}

}
