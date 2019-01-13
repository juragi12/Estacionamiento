package co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.repositorio;

import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad.SitioParqueo;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad.vehiculo.Vehiculo;
import co.com.ceiba.estacionamiento.juan.giraldo.persistencia.entidad.SitioParqueoEntidad;
import co.com.ceiba.estacionamiento.juan.giraldo.persistencia.entidad.VehiculoEntidad;

public interface RepositorioSitioParqueo {

	/*
	 * Ocupa un sitio de parqueo en el repositorio
	 */
	SitioParqueoEntidad parquearVehiculo(SitioParqueo sitioParqueo, VehiculoEntidad vehiculoEntidad);
	
	/*
	 * Obtiene el sitio de parqueo para un vehiculo en el estacionamiento 
	 * almacenado en el repositorio
	 */
	SitioParqueoEntidad obtenerSitioParqueo(Vehiculo vehiculo);
	
	/*
	 * Actualiza el repositorio de sitio de parqueo
	 */
	SitioParqueoEntidad liberar(SitioParqueo sitioParqueo);
	
}
