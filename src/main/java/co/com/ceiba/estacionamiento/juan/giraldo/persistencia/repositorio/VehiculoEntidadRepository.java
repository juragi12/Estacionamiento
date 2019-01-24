package co.com.ceiba.estacionamiento.juan.giraldo.persistencia.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.ceiba.estacionamiento.juan.giraldo.persistencia.entidad.VehiculoEntidad;

public interface VehiculoEntidadRepository extends JpaRepository<VehiculoEntidad, Long> {

	public VehiculoEntidad findByPlaca(String placa);
}
