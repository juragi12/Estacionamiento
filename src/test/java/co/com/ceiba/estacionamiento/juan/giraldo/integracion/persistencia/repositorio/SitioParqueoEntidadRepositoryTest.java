package co.com.ceiba.estacionamiento.juan.giraldo.integracion.persistencia.repositorio;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import co.com.ceiba.estacionamiento.juan.giraldo.persistencia.entidad.SitioParqueoEntidad;
import co.com.ceiba.estacionamiento.juan.giraldo.persistencia.entidad.VehiculoEntidad;
import co.com.ceiba.estacionamiento.juan.giraldo.persistencia.repositorio.SitioParqueoEntidadRepository;
import co.com.ceiba.estacionamiento.juan.giraldo.persistencia.repositorio.VehiculoEntidadRepository;
import databuilder.SitioParqueoDataBuilder;
import databuilder.VehiculoDataBuilder;



@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
public class SitioParqueoEntidadRepositoryTest {
	
    @Autowired
    private VehiculoEntidadRepository vehiculoEntidadRepository;
    
    @Autowired
    private SitioParqueoEntidadRepository sitioParqueoEntidadRepository;
        
    VehiculoDataBuilder vehiculoDataBuilder;
    SitioParqueoDataBuilder sitioParqueoDataBuilder;
    
	@Before
	public void init() {
		
		vehiculoDataBuilder = 
				new VehiculoDataBuilder();
				
		vehiculoEntidadRepository.save(vehiculoDataBuilder.buildVehiculoEntidad());
		
		sitioParqueoDataBuilder = 
				new SitioParqueoDataBuilder(); 
	}
    
    @Test
    public void whenSave_thenReturnSitioParqueoEntidad() {
    	
        // given
    	VehiculoEntidad vehiculoEncontrado = vehiculoEntidadRepository.findByPlaca(vehiculoDataBuilder.getPlaca());
    	sitioParqueoDataBuilder.setVehiculoEntidad(vehiculoEncontrado);

        // when
    	SitioParqueoEntidad SitioParqueoEntidad =
    			sitioParqueoEntidadRepository.save(sitioParqueoDataBuilder.buildSitioParqueoEntidad());
    	
    	SitioParqueoEntidad SitioParqueoEntidadEncontrado =
    			sitioParqueoEntidadRepository.findById(SitioParqueoEntidad.getId()).get();
    	
        // then
        assertTrue( sitioParqueoDataBuilder.compararSitiosParqueo(SitioParqueoEntidadEncontrado) );
    }
}
