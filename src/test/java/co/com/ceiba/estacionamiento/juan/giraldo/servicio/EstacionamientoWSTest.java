//package co.com.ceiba.estacionamiento.juan.giraldo.servicio;
//
//import static org.junit.Assert.*;
//import javax.ws.rs.core.Response;
//
//import org.junit.Test;
//import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad.vehiculo.Vehiculo;
//import co.com.ceiba.estacionamiento.juan.giraldo.persistencia.entidad.SitioParqueoEntidad;
//import databuilder.SitioParqueoDataBuilder;
//import databuilder.VehiculoDataBuilder;
//
//public class EstacionamientoWSTest {
//
//	private final int PRECIO_A_PAGAR = 0;
//	
//
//	ServicioEstacionamiento servicioEstacionamiento;
//	EstacionamientoWS estacionamientoWS = new EstacionamientoWS();
//
//	@Test
//	public void testRegistrarIngreso() {
//
//		// Arrange
//		Vehiculo vehiculo = new VehiculoDataBuilder().buildVehiculo();
//		SitioParqueoEntidad sitioParqueoEntidad = new SitioParqueoDataBuilder().buildSitioParqueoEntidad();
//		
//		Response responseActual = Response.ok(sitioParqueoEntidad).build();
//		
//		// Act
//		Response response = estacionamientoWS.registrarIngreso(vehiculo);
//		
//		// Assert
//		assertTrue( assertResponse (response, responseActual) );
//	}
//
//	@Test
//	public void testRegistrarSalida() {
//		
//		// Arrange		
//		//Ingresa vehiculo
//		Vehiculo vehiculo = new VehiculoDataBuilder().buildVehiculo();
//		estacionamientoWS.registrarIngreso(vehiculo);		
//		//Salida vehiculo
//		Response responseActual = Response.ok(PRECIO_A_PAGAR).build();
//		
//		// Act
//		Response response = estacionamientoWS.registrarSalida(vehiculo);
//		
//		// Assert
//		assertTrue( assertResponse (response, responseActual) );
//		
//		
//	}
//
//	@Test
//	public void testConsultarParqueadero() {
//		
//		// Arrange		
//		//Ingresa vehiculo
//		Vehiculo vehiculo = new VehiculoDataBuilder().buildVehiculo();
//		estacionamientoWS.registrarIngreso(vehiculo);	
//		EstacionamientoWS estacionamientoWS = new EstacionamientoWS();
//		estacionamientoWS.registrarIngreso(vehiculo);
//		estacionamientoWS.registrarIngreso(vehiculo);
//		//Consulta parqueadero
//		Response responseActual = estacionamientoWS.consultarParqueadero();
//		
//		// Act
//		Response response = estacionamientoWS.consultarParqueadero();
//
//		
//		// Assert
//		assertTrue( assertResponse (response, responseActual) );
//		
//	}
//
//	public boolean assertResponse(Response response, Response responseActual ) {
//		
//		if (  response.getStatus() != responseActual.getStatus()  ) {
//			return false;
//		}
//		
//		if (  response.getEntity().getClass() != responseActual.getEntity().getClass()  ) {
//			return false;
//		}
//		
//		return true;
//	}
//}
