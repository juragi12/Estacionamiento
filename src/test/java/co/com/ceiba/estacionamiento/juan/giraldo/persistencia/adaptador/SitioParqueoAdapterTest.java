package co.com.ceiba.estacionamiento.juan.giraldo.persistencia.adaptador;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad.SitioParqueo;
import co.com.ceiba.estacionamiento.juan.giraldo.persistencia.entidad.SitioParqueoEntidad;
import co.com.ceiba.estacionamiento.juan.giraldo.persistencia.entidad.VehiculoEntidad;
import databuilder.SitioParqueoDataBuilder;
import databuilder.VehiculoDataBuilder;

public class SitioParqueoAdapterTest {

	private static final boolean ACTIVO = true;
	private static final Date FECHA_INICIO = new Date();
	private static final Date FECHA_FIN = new Date();;
	private static final int POSICION = 1;
	
	
	@Test
	public void testGetSitioParqueoEntidad() {
		
		// Arrange
		VehiculoDataBuilder vehiculoDataBuilder = new VehiculoDataBuilder();
		VehiculoEntidad vehiculoEntidadActual = vehiculoDataBuilder.buildVehiculoEntidad();
		
		SitioParqueoDataBuilder sitioParqueoDataBuilder = 
				new SitioParqueoDataBuilder()
				.setActivo(ACTIVO)
				.setFechaInicio(FECHA_INICIO)
				.setFechaFin(FECHA_FIN)
				.setPosicion(POSICION)
				.setVehiculoEntidad(vehiculoEntidadActual);
		
		SitioParqueoEntidad sitioParqueoEntidadActual = sitioParqueoDataBuilder.buildSitioParqueoEntidad();
		SitioParqueo sitioParqueo = sitioParqueoDataBuilder.buildSitioParqueo();
		
		// Act
		SitioParqueoEntidad sitioParqueoEntidad = SitioParqueoAdapter.getSitioParqueoEntidad(sitioParqueo, vehiculoEntidadActual);
		
		// Assert
		assertTrue( assertGetSitioParqueoEntidadTest(sitioParqueoEntidad, sitioParqueoEntidadActual) );	
		
	}
	
	public boolean assertGetSitioParqueoEntidadTest(SitioParqueoEntidad sitioParqueoEntidad, SitioParqueoEntidad sitioParqueoEntidadActual) {
		
		if ( sitioParqueoEntidad.isActivo() != sitioParqueoEntidadActual.isActivo()  ) {
			return false;
		}
		
		if ( sitioParqueoEntidad.getFechaInicio() != sitioParqueoEntidadActual.getFechaInicio() ) {
			return false;
		}
		
		if ( sitioParqueoEntidad.getFechaFin() != sitioParqueoEntidadActual.getFechaFin() ) {
			return false;
		}
		
		if ( sitioParqueoEntidad.getPosicion() != sitioParqueoEntidadActual.getPosicion() ) {
			return false;
		}
		
		return true;
		
	}

}
