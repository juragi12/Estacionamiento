package co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad.vehiculo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

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
