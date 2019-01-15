package databuilder;

import java.util.Date;

import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad.SitioParqueo;
import co.com.ceiba.estacionamiento.juan.giraldo.persistencia.entidad.SitioParqueoEntidad;
import co.com.ceiba.estacionamiento.juan.giraldo.persistencia.entidad.VehiculoEntidad;

public class SitioParqueoDataBuilder {


	private static final boolean ACTIVO = true;
	private static final Date FECHA_INICIO = new Date();
	private static final Date FECHA_FIN = new Date();;
	private static final int POSICION = 1;
	
	private boolean activo;
	private Date fechaInicio;
	private Date fechaFin;
	private int posicion;
	private VehiculoEntidad vehiculo;
	
	public SitioParqueoDataBuilder() {
		this.activo = ACTIVO;
		this.fechaInicio = FECHA_INICIO;
		this.fechaFin = FECHA_FIN;
		this.posicion = POSICION;
		this.vehiculo = new VehiculoDataBuilder().buildVehiculoEntidad();
	}

	public SitioParqueoDataBuilder setVehiculoEntidad(VehiculoEntidad vehiculo) {
		this.vehiculo = vehiculo;
		return this;
	}
	
	public SitioParqueoDataBuilder setActivo(boolean activo) {
		this.activo = activo;
		return this;
	}

	public SitioParqueoDataBuilder setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
		return this;
	}

	public SitioParqueoDataBuilder setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
		return this;
	}

	public SitioParqueoDataBuilder setPosicion(int posicion) {
		this.posicion = posicion;
		return this;
	}
	
	public SitioParqueo buildSitioParqueo() {
		return new SitioParqueo(this.activo, this.fechaInicio, this.fechaFin, this.posicion);
	}
	
	public SitioParqueoEntidad buildSitioParqueoEntidad() {
		return new SitioParqueoEntidad(this.activo, this.fechaInicio, 
				this.fechaFin, this.posicion, this.vehiculo );
	}
	
	
}
