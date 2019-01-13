package co.com.ceiba.estacionamiento.juan.giraldo.persistencia.adaptador;

import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad.SitioParqueo;
import co.com.ceiba.estacionamiento.juan.giraldo.persistencia.entidad.SitioParqueoEntidad;
import co.com.ceiba.estacionamiento.juan.giraldo.persistencia.entidad.VehiculoEntidad;

public class SitioParqueoAdapter {
	
	public static SitioParqueoEntidad getSitioParqueoEntidad(SitioParqueo sitioParqueo, 
			VehiculoEntidad vehiculoEntidad) {
		
		return new SitioParqueoEntidad(
				sitioParqueo.isActivo(), sitioParqueo.getFechaInicio(), 
				sitioParqueo.getFechaFin(), sitioParqueo.getPosicion(), 
				vehiculoEntidad
				);
	}

}
