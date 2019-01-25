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

import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.repositorio.SitioParqueoEntidadService;
import co.com.ceiba.estacionamiento.juan.giraldo.persistencia.entidad.SitioParqueoEntidad;
import co.com.ceiba.estacionamiento.juan.giraldo.persistencia.entidad.VehiculoEntidad;
import co.com.ceiba.estacionamiento.juan.giraldo.persistencia.repositorio.SitioParqueoEntidadRepository;
import co.com.ceiba.estacionamiento.juan.giraldo.persistencia.repositorio.SitioParqueoEntidadServiceImpl;
import co.com.ceiba.estacionamiento.juan.giraldo.persistencia.repositorio.VehiculoEntidadRepository;
import databuilder.SitioParqueoDataBuilder;
import databuilder.VehiculoDataBuilder;


@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
public class SitioParqueoEntidadServiceImplTest {
	
    VehiculoDataBuilder vehiculoDataBuilder;
    SitioParqueoDataBuilder sitioParqueoDataBuilder;
    VehiculoEntidad vehiculoGuardado;
	
	@TestConfiguration
	static class SitioParqueoEntidadServiceImplTestContextConfiguration {
		
		@Bean
		public SitioParqueoEntidadService sitioParqueoEntidadServiceTest() {
			return new SitioParqueoEntidadServiceImpl();
		}
		
	}
	
	@Autowired
	SitioParqueoEntidadService sitioParqueoEntidadServiceTest;
	
    @Autowired
    private VehiculoEntidadRepository vehiculoEntidadRepository;
    
    @Autowired
    SitioParqueoEntidadRepository sitioParqueoEntidadRepository;
	
	@Before
	public void init() {
		
		vehiculoDataBuilder = 
				new VehiculoDataBuilder();
		
		sitioParqueoDataBuilder = 
				new SitioParqueoDataBuilder(); 
		
		vehiculoGuardado = vehiculoEntidadRepository.save(vehiculoDataBuilder.buildVehiculoEntidad());
	}
	
	@Test
	public void testParquearVehiculo() {
		
        // given
    	SitioParqueoEntidad sitioParqueoEntidad = sitioParqueoDataBuilder
    			.setVehiculoEntidad(vehiculoGuardado)
    			.buildSitioParqueoEntidad();
    	
    	
        // when
    	SitioParqueoEntidad sitioParqueoEntidadGuardado = sitioParqueoEntidadServiceTest.parquearVehiculo(sitioParqueoEntidad);	 
        
        // then
        assertTrue( sitioParqueoDataBuilder.compararSitiosParqueo(sitioParqueoEntidadGuardado) );

	}

	@Test
	public void testObtenerSitioParqueo() {
		
        // given  	
    	SitioParqueoEntidad sitioParqueoEntidad = sitioParqueoDataBuilder
    			.setVehiculoEntidad(vehiculoGuardado)
    			.buildSitioParqueoEntidad();
    	sitioParqueoEntidadServiceTest.parquearVehiculo(sitioParqueoEntidad);
    	
        // when	
    	SitioParqueoEntidad sitioParqueoEntidadObtenido = 
    			sitioParqueoEntidadServiceTest.obtenerSitioParqueo(vehiculoDataBuilder.buildVehiculo());
        
        // then
        assertTrue( sitioParqueoDataBuilder.compararSitiosParqueo(sitioParqueoEntidadObtenido) );
		
	}

	@Test
	public void testLiberar() {
		
        // given  	
    	SitioParqueoEntidad sitioParqueoEntidad = sitioParqueoDataBuilder
    			.setVehiculoEntidad(vehiculoGuardado)
    			.buildSitioParqueoEntidad();
    	
    	sitioParqueoEntidadServiceTest.parquearVehiculo(sitioParqueoEntidad);
    	
    	SitioParqueoEntidad sitioParqueoEntidadObtenido = 
    			sitioParqueoEntidadServiceTest.obtenerSitioParqueo(vehiculoDataBuilder.buildVehiculo());
    	
    	sitioParqueoDataBuilder.setActivo(false);
    	
        // when
    	SitioParqueoEntidad sitioParqueoEntidadLiberado = 
    			sitioParqueoEntidadServiceTest.liberar(sitioParqueoEntidadObtenido);
        
        // then
        assertTrue( sitioParqueoDataBuilder.compararSitiosParqueo(sitioParqueoEntidadLiberado) );
	}

}
