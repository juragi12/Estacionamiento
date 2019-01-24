package co.com.ceiba.estacionamiento.juan.giraldo.persistencia.repositorio;

import org.springframework.beans.factory.annotation.Autowired;

import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad.Vehiculo;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.repositorio.VehiculoEntidadService;
import co.com.ceiba.estacionamiento.juan.giraldo.persistencia.adaptador.VehiculoAdapter;
import co.com.ceiba.estacionamiento.juan.giraldo.persistencia.entidad.VehiculoEntidad;

public class VehiculoEntidadServiceImpl implements VehiculoEntidadService {

	@Autowired
	private VehiculoEntidadRepository vehiculoEntidadRepository;
	
	@Override
	public VehiculoEntidad guardar(Vehiculo vehiculo) {
		return vehiculoEntidadRepository.save(VehiculoAdapter.getVehiculoEntidad(vehiculo));
	}

	@Override
	public VehiculoEntidad byPlaca(Vehiculo vehiculo) {
		return vehiculoEntidadRepository.findByPlaca(vehiculo.getPlaca());
	}

	@Override
	public void borrar(Vehiculo vehiculo) {
		VehiculoEntidad vehiculoEntidad = vehiculoEntidadRepository.findByPlaca( vehiculo.getPlaca() );
		vehiculoEntidadRepository.deleteById(vehiculoEntidad.getId());
	}

}
