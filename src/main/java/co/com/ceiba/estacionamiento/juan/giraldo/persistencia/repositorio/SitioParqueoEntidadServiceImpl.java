package co.com.ceiba.estacionamiento.juan.giraldo.persistencia.repositorio;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad.Vehiculo;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.repositorio.SitioParqueoEntidadService;
import co.com.ceiba.estacionamiento.juan.giraldo.persistencia.entidad.SitioParqueoEntidad;

public class SitioParqueoEntidadServiceImpl implements SitioParqueoEntidadService {

	@Autowired
	private SitioParqueoEntidadRepository sitioParqueoEntidadRepository;
	
	@Override
	public SitioParqueoEntidad parquearVehiculo(SitioParqueoEntidad sitioParqueoEntidad) {
		return sitioParqueoEntidadRepository.save(sitioParqueoEntidad);
	}

	@Override
	public SitioParqueoEntidad obtenerSitioParqueo(Vehiculo vehiculo) {
		
		SitioParqueoEntidad sp;
		
		List<SitioParqueoEntidad> lista = sitioParqueoEntidadRepository.findByPlacaVehiculo(vehiculo.getPlaca());
		
		if ( ! lista.isEmpty() ) {
			Iterator<SitioParqueoEntidad> iterator = lista.iterator();
			while (iterator.hasNext()) {
				sp = iterator.next();
				
				if ( sp.isActivo() && sp.getVehiculo().getPlaca().equalsIgnoreCase(vehiculo.getPlaca()) ) {
					return sp;
				}
			}
		}		
		return null;
	}

	@Override
	public SitioParqueoEntidad liberar(SitioParqueoEntidad sitioParqueoEntidad) {
		sitioParqueoEntidad.setActivo(false);
		return sitioParqueoEntidadRepository.save(sitioParqueoEntidad);
	}

}
