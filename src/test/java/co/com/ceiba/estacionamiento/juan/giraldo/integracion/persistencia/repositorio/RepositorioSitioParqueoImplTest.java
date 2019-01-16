package co.com.ceiba.estacionamiento.juan.giraldo.integracion.persistencia.repositorio;
//package co.com.ceiba.estacionamiento.juan.giraldo.persistencia.repositorio;
//
//import static org.junit.Assert.*;
//
//import java.util.Date;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad.vehiculo.Vehiculo;
//import co.com.ceiba.estacionamiento.juan.giraldo.persistencia.entidad.SitioParqueoEntidad;
//import co.com.ceiba.estacionamiento.juan.giraldo.persistencia.entidad.VehiculoEntidad;
//import databuilder.SitioParqueoDataBuilder;
//import databuilder.VehiculoDataBuilder;
//
//public class RepositorioSitioParqueoImplTest {
//
//	private final boolean ACTIVO = true;
//	private final Date FECHA_INICIO = new Date();
//	private final Date FECHA_FIN = new Date();;
//	private final int POSICION = 1;
//	
//	Vehiculo vehiculo;
//	SitioParqueoEntidad sitioParqueoEntidad;
//	RepositorioSitioParqueoImpl repositorioSitioParqueo;
//	
//	@Before
//	public void init() {
//		
//		// Arrange
//		// guarda vehiculo en el repo vehiculo
//		vehiculo = new VehiculoDataBuilder().buildVehiculo();
//        RepositorioVehiculoImpl repositorioVeiculo = RepositorioFactory.obtenerRepositorioVehiculo();
//        VehiculoEntidad vehiculoEntidadActual = repositorioVeiculo.guardar(vehiculo);
//		
//		sitioParqueoEntidad = 
//				new SitioParqueoDataBuilder()
//				.setActivo(ACTIVO)
//				.setFechaInicio(FECHA_INICIO)
//				.setFechaFin(FECHA_FIN)
//				.setPosicion(POSICION)
//				.setVehiculoEntidad(vehiculoEntidadActual).buildSitioParqueoEntidad();	
//        
//		repositorioSitioParqueo = RepositorioFactory.obtenerRepositorioSitioParqueo();
//	}
//	
//	@Test
//	public void testParquearVehiculo() {
//		        
//        // Act
//        SitioParqueoEntidad sitParEnt = repositorioSitioParqueo.parquearVehiculo(sitioParqueoEntidad);
//        
//        
//        // Assert        
//        assertTrue(compararSitioParqueoEntidadTest(sitParEnt, sitioParqueoEntidad));
//	}
//
//	@Test
//	public void testObtenerSitioParqueo() {
//		
//        SitioParqueoEntidad sitParEnt = repositorioSitioParqueo.obtenerSitioParqueo(vehiculo);
//        
//        // Assert        
//        assertTrue(compararSitioParqueoEntidadTest(sitParEnt, sitioParqueoEntidad));
//
//	}
//
//	@Test
//	public void testLiberar() {
//		
//		SitioParqueoEntidad sitParEntALiberar = repositorioSitioParqueo.obtenerSitioParqueo(vehiculo);
//        SitioParqueoEntidad sitParEnt = repositorioSitioParqueo.liberar(sitParEntALiberar);
//        
//        // Assert        
//        assertTrue(compararSitioParqueoEntidadTest(sitParEnt, sitioParqueoEntidad));
//
//		
//	}
//
//	public boolean compararSitioParqueoEntidadTest(SitioParqueoEntidad sitioParqueoEntidad, SitioParqueoEntidad sitioParqueoEntidadActual) {
//		
//		if ( sitioParqueoEntidad.isActivo() != sitioParqueoEntidadActual.isActivo()  ) {
//			return false;
//		}
//		
//		if ( sitioParqueoEntidad.getPosicion() != sitioParqueoEntidadActual.getPosicion() ) {
//			return false;
//		}
//		
//		if ( sitioParqueoEntidad.getVehiculo().getPlaca() != sitioParqueoEntidadActual.getVehiculo().getPlaca() ) {
//			return false;
//		}
//		
//		return true;
//	}
//	
//}
