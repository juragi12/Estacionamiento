package co.com.ceiba.estacionamiento.juan.giraldo.persistencia.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.com.ceiba.estacionamiento.juan.giraldo.persistencia.entidad.SitioParqueoEntidad;

public interface SitioParqueoEntidadRepository extends JpaRepository<SitioParqueoEntidad, Long> {
	
	 @Query("SELECT sp FROM SitioParqueo sp, Vehiculo v WHERE sp.activo = true and v.placa = :placa")
	public List<SitioParqueoEntidad> findByPlacaVehiculo( @Param("placa") String placa);
}
