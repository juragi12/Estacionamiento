package co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.adaptador;

import static org.junit.Assert.*;

import org.junit.Test;

import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad.vehiculo.Vehiculo;
import co.com.ceiba.estacionamiento.juan.giraldo.persistencia.entidad.VehiculoEntidad;
import databuilder.VehiculoDataBuilder;

public class VehiculoAdapterTest {
	
	private static String PLACA = "CCC-123";
	private static int CILINDRAJE = 250;
	private static String TIPO_MOTO = "MOTO";

	@Test
	public void GetVehiculoTest() {
		
		//Arrange
		VehiculoDataBuilder vehiculoDataBuilder = 
				new VehiculoDataBuilder()
				.setPlaca(PLACA)
				.setCilindraje(CILINDRAJE)
				.setTipo(TIPO_MOTO);
		
		VehiculoEntidad vehiculoEntidad =  vehiculoDataBuilder.buildVehiculoEntidad();
		Vehiculo vehiculoActual = vehiculoDataBuilder.buildVehiculo();
				
		//Act
		Vehiculo vehiculo = VehiculoAdapter.getVehiculo(vehiculoEntidad);
		
		//Assert
		assertTrue( assertGetVehiculoTest(vehiculo, vehiculoActual) );
		

	}

	public boolean assertGetVehiculoTest(Vehiculo vehiculo, Vehiculo vehiculoActual) {
		
	
		if ( vehiculo.getPlaca() != vehiculoActual.getPlaca() ) {
			return false;
		}
		if ( vehiculo.getCilindraje() != vehiculoActual.getCilindraje() ) {
			return false;
		}
		if ( vehiculo.getTipo() != vehiculoActual.getTipo() ) {
			return false;
		}
		
		return true;
	}
}
