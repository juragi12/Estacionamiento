package co.com.ceiba.estacionamiento.juan.giraldo.unitaria.servicio;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.doReturn;

import javax.ws.rs.core.Response;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad.vehiculo.Vehiculo;
import co.com.ceiba.estacionamiento.juan.giraldo.controlador.EstacionamientoWS;
import co.com.ceiba.estacionamiento.juan.giraldo.controlador.ServicioEstacionamiento;
import co.com.ceiba.estacionamiento.juan.giraldo.persistencia.entidad.SitioParqueoEntidad;
import databuilder.SitioParqueoDataBuilder;
import databuilder.VehiculoDataBuilder;

public class EstacionamientoWSTest {

	private final String MENSAJE = "Hola al Estacionamiento Juan Giraldo";
	private final int PRECIO_A_PAGAR = 4000;
		
	@Mock
	ServicioEstacionamiento servicioEstacionamiento;
	
	@InjectMocks
	EstacionamientoWS estacionamientoWS = new EstacionamientoWS();
	
	
	@Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void testWelcome() {
		
		// Act
		String mensaje = estacionamientoWS.welcome();
		
		// Assert
		assertTrue(mensaje.equals(MENSAJE));
	}

	@Test
	public void testRegistrarIngreso() {
		
		// Arrange
		Vehiculo vehiculo = new VehiculoDataBuilder().buildVehiculo();
		SitioParqueoEntidad sitioParqueoEntidad = new SitioParqueoDataBuilder().buildSitioParqueoEntidad();
		
		doReturn(sitioParqueoEntidad).when(servicioEstacionamiento).registrarIngresoVehiculo(vehiculo);		
		Response responseActual = Response.ok(sitioParqueoEntidad).build();
		
		// Act
		Response response = estacionamientoWS.registrarIngreso(vehiculo);
		
		// Assert
		assertTrue( assertResponse (response, responseActual) );
	}

	@Test
	public void testRegistrarSalida() {
		
		// Arrange
		Vehiculo vehiculo = new VehiculoDataBuilder().buildVehiculo();
		
		doReturn(PRECIO_A_PAGAR).when(servicioEstacionamiento).registrarSalidaVehiculo(vehiculo);
		Response responseActual = Response.ok(PRECIO_A_PAGAR).build();
		
		// Act
		Response response = estacionamientoWS.registrarSalida(vehiculo);
		
		// Assert
		assertTrue( assertResponse (response, responseActual) );
		
	}

	@Test
	public void testConsultarParqueadero() {
		
		// Arrange
		List<SitioParqueoEntidad> parqueadero = new ArrayList<SitioParqueoEntidad>();
		SitioParqueoEntidad sitioParqueoEntidad = new SitioParqueoDataBuilder().buildSitioParqueoEntidad();	
		parqueadero.add(sitioParqueoEntidad);
		
		doReturn(parqueadero).when(servicioEstacionamiento).consultarVehiculos();
		Response responseActual = Response.ok(servicioEstacionamiento.consultarVehiculos()).build();	 
		
		// Act
		Response response = estacionamientoWS.consultarParqueadero();
		
		// Assert
		assertTrue( assertResponse (response, responseActual) );
	}

	
	public boolean assertResponse(Response response, Response responseActual ) {
				
		if (  response.getStatus() != responseActual.getStatus()  ) {
			return false;
		}
		
		if (  response.getEntity().getClass() != responseActual.getEntity().getClass()  ) {
			return false;
		}
		
		return true;
	}
}
