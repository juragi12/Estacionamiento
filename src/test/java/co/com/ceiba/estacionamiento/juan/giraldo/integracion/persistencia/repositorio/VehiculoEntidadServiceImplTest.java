package co.com.ceiba.estacionamiento.juan.giraldo.integracion.persistencia.repositorio;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad.Vehiculo;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.repositorio.VehiculoEntidadService;
import co.com.ceiba.estacionamiento.juan.giraldo.persistencia.entidad.VehiculoEntidad;
import co.com.ceiba.estacionamiento.juan.giraldo.persistencia.repositorio.VehiculoEntidadServiceImpl;
import databuilder.VehiculoDataBuilder;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
public class VehiculoEntidadServiceImplTest {
	
	@TestConfiguration
	static class VehiculoEntidadServiceImplTestTestContextConfiguration {
		
		@Bean
		public VehiculoEntidadService vehiculoEntidadService() {
			return new VehiculoEntidadServiceImpl();
		}
		
	}
	
	@Autowired
	VehiculoEntidadService vehiculoEntidadService;
		
	VehiculoDataBuilder vehiculoDataBuilder;
	
    @Before
    public void init() {
		vehiculoDataBuilder = 
				new VehiculoDataBuilder();
		
    }

	@Test
	public void WhenGuardarVehiculo_ThenReturnVehiculo() {
        // given
    	Vehiculo vehiculo = vehiculoDataBuilder.buildVehiculo();    	
    	
        // when
    	VehiculoEntidad vehiculoGuardado = vehiculoEntidadService.guardar(vehiculo);  
    	vehiculoEntidadService.borrar(vehiculo);
        
        // then
        assertTrue( vehiculoDataBuilder.compararVehiculos(vehiculoGuardado) );
	}
	
	@Test
	public void whenByPlaca_ThenReturnVehiculo() {
        // given
    	Vehiculo vehiculo = vehiculoDataBuilder.buildVehiculo();   
    	vehiculoEntidadService.guardar(vehiculo);   
    	
        // when
    	VehiculoEntidad vehiculoEncontrado = vehiculoEntidadService.byPlaca( vehiculo );   
    	vehiculoEntidadService.borrar(vehiculo);
    	
        // then
        assertTrue( vehiculoDataBuilder.compararVehiculos(vehiculoEncontrado) );
	}
}
