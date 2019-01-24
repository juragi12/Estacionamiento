package co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.repositorio;

import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad.Vehiculo;
import co.com.ceiba.estacionamiento.juan.giraldo.persistencia.entidad.SitioParqueoEntidad;

public interface SitioParqueoEntidadService {

	/*
	 * Ocupa un sitio de parqueo en el repositorio
	 */
	SitioParqueoEntidad parquearVehiculo(SitioParqueoEntidad sitioParqueoEntidad);
	
	/*
	 * Obtiene el sitio de parqueo para un vehiculo en el estacionamiento 
	 * almacenado en el repositorio
	 */
	SitioParqueoEntidad obtenerSitioParqueo(Vehiculo vehiculo);
	
	/*
	 * Actualiza el repositorio de sitio de parqueo
	 */
	SitioParqueoEntidad liberar(SitioParqueoEntidad sitioParqueoEntidad);
	
}
