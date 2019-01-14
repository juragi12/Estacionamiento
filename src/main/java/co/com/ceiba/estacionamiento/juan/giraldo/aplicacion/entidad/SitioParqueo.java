package co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad;

import java.util.Date;

public class SitioParqueo {

	public SitioParqueo(boolean activo, Date fechaInicio, Date fechaFin, int posicion) {
		super();
		this.activo = activo;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.posicion = posicion;
	}
	
	public SitioParqueo() {
		
	}

	private boolean activo;
	private Date fechaInicio;
	private Date fechaFin;
	private int posicion;
	
	

	public Date getFechaFin() {
		return fechaFin;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public int getPosicion() {
		return posicion;
	}

	public boolean isActivo() {
		return activo;
	}
	
	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}
}
