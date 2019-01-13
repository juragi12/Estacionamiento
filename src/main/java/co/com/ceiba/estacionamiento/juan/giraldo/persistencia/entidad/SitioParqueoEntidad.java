package co.com.ceiba.estacionamiento.juan.giraldo.persistencia.entidad;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity(name = "SitioParqueo")
@NamedQuery(name = "SitioParqueo.findByPlacaVehiculo",
	query = "SELECT sp FROM SitioParqueo sp, Vehiculo v WHERE sp.activo = true and v.placa = :placa")
public class SitioParqueoEntidad {

	@Id
	@GeneratedValue
	private int id;

	private boolean activo;
	private Date fechaInicio;
	private Date fechaFin;
	private int posicion;

	@ManyToOne
	@JoinColumn(name = "id_vehiculo", referencedColumnName = "id")
	private VehiculoEntidad vehiculoEntidad;

	public SitioParqueoEntidad(boolean activo, Date fechaInicio, Date fechaFin, int posicion,
			VehiculoEntidad vehiculoEntidad) {
		this.activo = activo;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.posicion = posicion;
		this.vehiculoEntidad = vehiculoEntidad;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public int getId() {
		return id;
	}

	public int getPosicion() {
		return posicion;
	}

	public VehiculoEntidad getVehiculo() {
		return vehiculoEntidad;
	}

	public boolean isActivo() {
		return activo;
	}
}