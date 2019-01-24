package co.com.ceiba.estacionamiento.juan.giraldo.integracion.persistencia.repositorio;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import co.com.ceiba.estacionamiento.juan.giraldo.persistencia.entidad.VehiculoEntidad;
import co.com.ceiba.estacionamiento.juan.giraldo.persistencia.repositorio.VehiculoEntidadRepository;
import databuilder.VehiculoDataBuilder;


@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
public class VehiculoEntidadRepositoryTest {


    @Autowired
    private TestEntityManager entityManager;
    
    @Autowired
    private VehiculoEntidadRepository vehiculoEntidadRepository;
    
    VehiculoDataBuilder vehiculoDataBuilder;
    
    @Before
    public void init() {
		vehiculoDataBuilder = 
				new VehiculoDataBuilder();
		
    }
  
    @Test
    public void whenFindByPlaca_thenReturnVehiculoEntidad() {
        // given
        entityManager.persist(vehiculoDataBuilder.buildVehiculoEntidad());
        entityManager.flush();
     
        // when
        VehiculoEntidad vehiculoEncontrado = vehiculoEntidadRepository.findByPlaca(vehiculoDataBuilder.getPlaca());
        vehiculoEntidadRepository.deleteById(vehiculoEncontrado.getId());
     
        // then
        assertTrue( vehiculoDataBuilder.compararVehiculos(vehiculoEncontrado) );
    }
    
    @Test
    public void whenSave_thenReturnVehiculoEntidad() {
    	
        // given
    	VehiculoEntidad vehiculo = vehiculoDataBuilder.buildVehiculoEntidad();

        // when
        vehiculoEntidadRepository.save(vehiculo);
        VehiculoEntidad vehiculoEncontrado = vehiculoEntidadRepository.findByPlaca(vehiculo.getPlaca());    
        vehiculoEntidadRepository.deleteById(vehiculoEncontrado.getId());
        
        // then
        assertTrue( vehiculoDataBuilder.compararVehiculos(vehiculoEncontrado) );
    }

}
