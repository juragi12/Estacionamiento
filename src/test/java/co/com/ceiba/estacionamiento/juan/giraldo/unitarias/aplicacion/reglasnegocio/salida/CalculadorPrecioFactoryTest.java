package co.com.ceiba.estacionamiento.juan.giraldo.unitarias.aplicacion.reglasnegocio.salida;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad.Vehiculo;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.reglasnegocio.salida.CalculadorPrecioCarro;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.reglasnegocio.salida.CalculadorPrecioFactory;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.reglasnegocio.salida.CalculadorPrecioMotoAltoCC;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.reglasnegocio.salida.CalculadorPrecioMotoBajoCC;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.reglasnegocio.salida.CalculadorPrecioParqueo;
import databuilder.VehiculoDataBuilder;


/*
 * Prueba que para cada tipo de vehiculo y cilindraje se retorne el calculador correcto
 */
public class CalculadorPrecioFactoryTest {
	
	private static String PLACA = "CCC-123";
	private static int CILINDRAJE_ALTO = 650;
	private static int CILINDRAJE_BAJO = 250;
	private static String TIPO_MOTO = "MOTO";
	private static String TIPO_CARRO = "CARRO";
	
	VehiculoDataBuilder vehiculoDataBuilder;
	
	@Before
	public void init() {
		 vehiculoDataBuilder = 
				new VehiculoDataBuilder()
				.setPlaca(PLACA)
				.setCilindraje(CILINDRAJE_ALTO)
				.setTipo(TIPO_MOTO);
    }

	@Test
	public void testGetCalculadorPrecioParqueoMotoAltoCC() {
		
		// Arrange
		Vehiculo vehiculo = vehiculoDataBuilder
				.setCilindraje(CILINDRAJE_ALTO)
				.setTipo(TIPO_MOTO)
				.buildVehiculo();

		// Act
		CalculadorPrecioParqueo calculador = CalculadorPrecioFactory.getCalculadorPrecioParqueo(vehiculo);
		
		// Assert
		assertTrue( calculador instanceof CalculadorPrecioMotoAltoCC );
	}
	
	@Test
	public void testGetCalculadorPrecioParqueoMotoBajoCC() {
		
		// Arrange
		Vehiculo vehiculo = vehiculoDataBuilder
				.setCilindraje(CILINDRAJE_BAJO)
				.setTipo(TIPO_MOTO)
				.buildVehiculo();

		// Act
		CalculadorPrecioParqueo calculador = CalculadorPrecioFactory.getCalculadorPrecioParqueo(vehiculo);
		
		// Assert
		assertTrue( calculador instanceof CalculadorPrecioMotoBajoCC );
	}
	
	@Test
	public void testGetCalculadorPrecioParqueoCarro() {
		
		// Arrange
		Vehiculo vehiculo = vehiculoDataBuilder
				.setTipo(TIPO_CARRO)
				.buildVehiculo();

		// Act
		CalculadorPrecioParqueo calculador = CalculadorPrecioFactory.getCalculadorPrecioParqueo(vehiculo);
		
		// Assert
		assertTrue( calculador instanceof CalculadorPrecioCarro );
	}
	

}
