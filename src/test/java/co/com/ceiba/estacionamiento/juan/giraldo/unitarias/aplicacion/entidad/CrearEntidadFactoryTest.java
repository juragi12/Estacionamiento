package co.com.ceiba.estacionamiento.juan.giraldo.unitarias.aplicacion.entidad;

import static org.junit.Assert.*;

import org.junit.Test;

import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad.CrearEntidadFactory;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad.EntidadFactory;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad.VehiculoFactory;
public class CrearEntidadFactoryTest {

	public final String TIPO_FABRICA_VEHICULO = "VEHICULO";
	
	@Test
	public void testGetVehiculoFactory() {
				
		// Act
		EntidadFactory entidadFactory = CrearEntidadFactory.getFactory(TIPO_FABRICA_VEHICULO);
		
		// Assert
		assertTrue( entidadFactory instanceof VehiculoFactory );
	}

	
	// Pendiente probar la excepcion
}
