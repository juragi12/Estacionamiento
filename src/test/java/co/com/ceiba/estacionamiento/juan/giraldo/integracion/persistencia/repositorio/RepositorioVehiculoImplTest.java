package co.com.ceiba.estacionamiento.juan.giraldo.integracion.persistencia.repositorio;
//package co.com.ceiba.estacionamiento.juan.giraldo.persistencia.repositorio;
//
//import static org.junit.Assert.*;
//
//import org.junit.Test;
//
//import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad.vehiculo.Vehiculo;
//import co.com.ceiba.estacionamiento.juan.giraldo.persistencia.entidad.VehiculoEntidad;
//import databuilder.VehiculoDataBuilder;
//
//public class RepositorioVehiculoImplTest {
//
//	@Test
//	public void testGuardarVehiculo() {
//		
//		// Arrange
//		Vehiculo vehiculo = new VehiculoDataBuilder().buildVehiculo();
//		
//        RepositorioVehiculoImpl repositorioVeiculo = RepositorioFactory.obtenerRepositorioVehiculo();
//        
//        // Act
//        VehiculoEntidad vehEnt = repositorioVeiculo.guardar(vehiculo);
//        
//        assertTrue(assertGuardarVehiculoTest(vehiculo, vehEnt));
//	}
//	
//	
//	public boolean assertGuardarVehiculoTest(Vehiculo vehiculo, VehiculoEntidad vehiculoActual) {
//		
//		
//		if ( vehiculo.getPlaca() != vehiculoActual.getPlaca() ) {
//			return false;
//		}
//		if ( vehiculo.getCilindraje() != vehiculoActual.getCilindraje() ) {
//			return false;
//		}
//		if ( vehiculo.getTipo() != vehiculoActual.getTipo() ) {
//			return false;
//		}
//		
//		return true;
//	}
//	
//	// pendiente validar el retorno de excepcion si no se envia vehiculo
//	// o ocurre una excepcion
//
//}
