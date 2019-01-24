package co.com.ceiba.estacionamiento.juan.giraldo.persistencia.entidad;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "SitioParqueo")
public class SitioParqueoEntidad {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

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

	public SitioParqueoEntidad() {
	}
	
	public Date getFechaFin() {
		return fechaFin;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public Long getId() {
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
	
	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}


}
