package co.com.ceiba.estacionamiento.juan.giraldo.persistencia.adaptador;

import static org.junit.Assert.*;

import org.junit.Test;

import co.com.ceiba.estacionamiento.juan.giraldo.persistencia.adaptador.VehiculoAdapter;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad.vehiculo.Vehiculo;
import co.com.ceiba.estacionamiento.juan.giraldo.persistencia.entidad.VehiculoEntidad;
import databuilder.VehiculoDataBuilder;

public class VehiculoAdapterTest {
	
	private static String PLACA = "CCC-123";
	private static int CILINDRAJE = 250;
	private static String TIPO_MOTO = "MOTO";

	@Test
	public void testGetVehiculoEntidad() {
		
		//Arrange
		VehiculoDataBuilder vehiculoDataBuilder = 
				new VehiculoDataBuilder()
				.setPlaca(PLACA)
				.setCilindraje(CILINDRAJE)
				.setTipo(TIPO_MOTO);
		
		VehiculoEntidad vehiculoEntidadActual =  vehiculoDataBuilder.buildVehiculoEntidad();
		Vehiculo vehiculo = vehiculoDataBuilder.buildVehiculo();
				
		//Act
		VehiculoEntidad vehiculoEntidad = VehiculoAdapter.getVehiculoEntidad(vehiculo);
		
		//Assert
		assertTrue( assertGetVehiculoTest(vehiculoEntidad, vehiculoEntidadActual) );
	}
	
	public boolean assertGetVehiculoTest(VehiculoEntidad vehiculo, VehiculoEntidad vehiculoActual) {
		
		
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
