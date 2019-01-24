package co.com.ceiba.estacionamiento.juan.giraldo.unitarias.aplicacion.entidad;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad.Carro;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad.Moto;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad.Vehiculo;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad.VehiculoFactory;

public class VehiculoFactoryTest {

	public final String TIPO_MOTO = "MOTO";
	public final String TIPO_CARRO = "CARRO";
	VehiculoFactory vehiculoFactory;
	
	@Before
	public void init() {
		vehiculoFactory = new VehiculoFactory();
	}
	
	@Test
	public void testGetVehiculoCarro() {
		
		// Arrange
		Vehiculo vehiculo;
		
		// Act
		vehiculo = vehiculoFactory.getVehiculo(TIPO_CARRO);
		
		// Assert
		assertTrue( vehiculo instanceof Carro );
	}

	@Test
	public void testGetVehiculoMoto() {
		
		// Arrange
		Vehiculo vehiculo;
		
		// Act
		vehiculo = vehiculoFactory.getVehiculo(TIPO_MOTO);
		
		// Assert
		assertTrue( vehiculo instanceof Moto );
		
	}
	
	// Pendiente la excepcion
}
