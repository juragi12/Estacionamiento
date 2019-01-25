package co.com.ceiba.estacionamiento.juan.giraldo.integracion.aplicacion;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.AdminEstacionamientoImpl;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.ServicioEstacionamientoImpl;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad.Vehiculo;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.excepcion.EstacionamientoExcepcion;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.repositorio.SitioParqueoEntidadService;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.repositorio.VehiculoEntidadService;
import co.com.ceiba.estacionamiento.juan.giraldo.controlador.ServicioEstacionamiento;
import co.com.ceiba.estacionamiento.juan.giraldo.persistencia.entidad.SitioParqueoEntidad;
import co.com.ceiba.estacionamiento.juan.giraldo.persistencia.entidad.VehiculoEntidad;
import co.com.ceiba.estacionamiento.juan.giraldo.persistencia.repositorio.SitioParqueoEntidadServiceImpl;
import co.com.ceiba.estacionamiento.juan.giraldo.persistencia.repositorio.VehiculoEntidadServiceImpl;
import databuilder.SitioParqueoDataBuilder;
import databuilder.VehiculoDataBuilder;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
public class ServicioEstacionamientoImplTest {

	private final String TIPO_MOTO = "MOTO";
	private final String TIPO_CARRO = "CARRO";
	private final int NUM_MAX_CARROS = 20;
	private final int NUM_MAX_MOTOS = 10;
	
    VehiculoDataBuilder vehiculoDataBuilder;
    SitioParqueoDataBuilder sitioParqueoDataBuilder;
    VehiculoEntidad vehiculoGuardado;
	
	@TestConfiguration
	static class ServicioEstacionamientoImplTestContextConfiguration {
		
		@Bean
		public ServicioEstacionamiento servicioEstacionamiento() {
			return new ServicioEstacionamientoImpl();
		}
		
		@Bean
		public VehiculoEntidadService vehiculoEntidadService() {
			return new VehiculoEntidadServiceImpl();
		}
		
		@Bean
		public SitioParqueoEntidadService sitioParqueoEntidadService() {
			return new SitioParqueoEntidadServiceImpl();
		}
		
		@Bean
		public AdminEstacionamientoImpl adminEstacionamiento() {
			return new AdminEstacionamientoImpl();
		}	
		
	}
		
	@Autowired
	ServicioEstacionamiento servicioEstacionamiento;
	
	@Before
	public void init() {
		
		vehiculoDataBuilder = 
				new VehiculoDataBuilder();
		
		sitioParqueoDataBuilder = 
				new SitioParqueoDataBuilder(); 
	}
	
	@Test
	public void parquearCarro() {
		
		String placa = "BDD-000";
		// Arrange
		VehiculoDataBuilder vehiculoDataBuilder = 
				new VehiculoDataBuilder()
				.setPlaca(placa)
				.setTipo(TIPO_CARRO);
		
		Vehiculo vehiculoPreuba = vehiculoDataBuilder.buildVehiculo();
		
		// Act
		SitioParqueoEntidad sp = 
				servicioEstacionamiento.registrarIngresoVehiculo(vehiculoPreuba);
		
		servicioEstacionamiento.registrarSalidaVehiculo(vehiculoPreuba);
		
		// Assert
		assertTrue( vehiculoDataBuilder.compararVehiculos(sp.getVehiculo()) );
	}

	@Test
	public void parquearMoto() {
		
		String placa = "BDD-001";
		// Arrange
		VehiculoDataBuilder vehiculoDataBuilder = 
				new VehiculoDataBuilder()
				.setPlaca(placa)
				.setTipo(TIPO_MOTO);
		
		Vehiculo vehiculoPreuba = vehiculoDataBuilder.buildVehiculo();
		
		// Act
		SitioParqueoEntidad sp = 
				servicioEstacionamiento.registrarIngresoVehiculo(vehiculoPreuba);
		
		servicioEstacionamiento.registrarSalidaVehiculo(vehiculoPreuba);
		
		// Assert
		assertTrue( vehiculoDataBuilder.compararVehiculos(sp.getVehiculo()) );
	}
	
	@Test
	public void parquearMaxMotosYMaxCarros() {
		
		// Almacena num maximo de Carros
		this.registrarIngresoVehiculos(NUM_MAX_CARROS, TIPO_CARRO);
	
		// Almacena num maximo de Motos
		this.registrarIngresoVehiculos(NUM_MAX_MOTOS, TIPO_MOTO);
		
		int numVehiculosParqueados =
				servicioEstacionamiento.consultarVehiculos().size();
		
		// Registra salida de Carros
		this.registrarSalidaVehiculos(NUM_MAX_CARROS, TIPO_CARRO);
		
		// Registra salida de Motos
		this.registrarSalidaVehiculos(NUM_MAX_MOTOS, TIPO_MOTO);
		
		// Assert
		assertEquals(NUM_MAX_CARROS+NUM_MAX_MOTOS, numVehiculosParqueados);
		
	}	
	
	@Test(expected = RuntimeException.class)
	public void parquearMasMotosQuePosibles() {
		
		try {
			// Almacena num maximo de Motos + 1
			this.registrarIngresoVehiculos(NUM_MAX_MOTOS+1, TIPO_MOTO);
		} catch (Exception e) {
			// Registra salida de Motos
			this.registrarSalidaVehiculos(NUM_MAX_MOTOS, TIPO_MOTO);
	
			// Assert
			assertTrue(e.getMessage().equalsIgnoreCase(
					EstacionamientoExcepcion.PARQUEADERO_MOTOS_COMPLETO.toString() )
					);
			
			throw e;
		}		
	}
	
	@Test(expected = RuntimeException.class)
	public void parquearMasCarroQuePosibles() {
		
		try {
			// Almacena num maximo de Carros + 1
			this.registrarIngresoVehiculos(NUM_MAX_CARROS+1, TIPO_CARRO);
		} catch (Exception e) {
			// Registra salida de Carros
			this.registrarSalidaVehiculos(NUM_MAX_CARROS, TIPO_CARRO);
	
			// Assert
			assertTrue(e.getMessage().equalsIgnoreCase(
					EstacionamientoExcepcion.PARQUEADERO_CARROS_COMPLETO.toString() )
					);
			
			throw e;
		}		
	}	
	
	@Test
	public void consultarVehiculosParqueado() {

		int numCarrosParqueadosEsp = NUM_MAX_CARROS;
		int numCarrosParqueados = 0;
		// Almacena num maximo de Carros
		this.registrarIngresoVehiculos(NUM_MAX_CARROS, TIPO_CARRO);
		
		List<Object> parqueadero = 
				servicioEstacionamiento.consultarVehiculos();
		numCarrosParqueados = parqueadero.size();
		// Registra salida de Carros
		this.registrarSalidaVehiculos(NUM_MAX_CARROS, TIPO_CARRO);
		
		// Assert
		assertTrue(numCarrosParqueados == numCarrosParqueadosEsp );
	}	
	
	public void registrarIngresoVehiculos(int cantidad, String tipo) {
		
		String placa = "";
		String placa_tipo_moto = "BD-";
	    String placa_tipo_carro = "BDD-";
		
		VehiculoDataBuilder vehiculoDataBuilder = 
				new VehiculoDataBuilder();
		Vehiculo vehiculoPreuba;  
		
		if(tipo.contentEquals(TIPO_CARRO)) {
			placa = placa_tipo_carro;	}
		if(tipo.contentEquals(TIPO_MOTO)) {
			placa = placa_tipo_moto;	}
		
		for (int i = 0; i < cantidad; i++) {
			placa = placa + String.valueOf(i);
			vehiculoPreuba = vehiculoDataBuilder
					.setPlaca(placa)
					.setTipo(tipo)
					.buildVehiculo();
			
			servicioEstacionamiento.registrarIngresoVehiculo(vehiculoPreuba);
		}
	}

	public void registrarSalidaVehiculos(int cantidad, String tipo) {
		
		String placa = "";
		String placa_tipo_moto = "BD-";
	    String placa_tipo_carro = "BDD-";
		
		VehiculoDataBuilder vehiculoDataBuilder = 
				new VehiculoDataBuilder();
		Vehiculo vehiculoPreuba;  
		
		if(tipo.contentEquals(TIPO_CARRO)) {
			placa = placa_tipo_carro;	}
		if(tipo.contentEquals(TIPO_MOTO)) {
			placa = placa_tipo_moto;	}
		
		for (int i = 0; i < cantidad; i++) {
			placa = placa + String.valueOf(i);
			vehiculoPreuba = vehiculoDataBuilder
					.setPlaca(placa)
					.setTipo(tipo)
					.buildVehiculo();
			
			servicioEstacionamiento.registrarSalidaVehiculo(vehiculoPreuba);
		}
	}
	
}
