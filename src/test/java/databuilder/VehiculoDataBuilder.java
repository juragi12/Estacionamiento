package databuilder;

import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad.CrearEntidadFactory;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad.EntidadFactory;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad.vehiculo.Vehiculo;
import co.com.ceiba.estacionamiento.juan.giraldo.persistencia.entidad.VehiculoEntidad;

public class VehiculoDataBuilder {
	
	private static String PLACA = "CCC-123";
	private static int CILINDRAJE = 250;
	private static String TIPO_MOTO = "MOTO";
	
	private String placa;
	private int cilindraje;
	private String tipo;
	
	public VehiculoDataBuilder() {
		this.placa = PLACA;
		this.cilindraje = CILINDRAJE;
		this.tipo = TIPO_MOTO;
	}
	
	public VehiculoDataBuilder setPlaca(String placa) {
		this.placa = placa;
		return this;
	}
	public VehiculoDataBuilder setCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
		return this;
	}
	public VehiculoDataBuilder setTipo(String tipo) {
		this.tipo = tipo;
		return this;
	}
	
	public Vehiculo buildVehiculo() {
		
		EntidadFactory vehiculoFactory = CrearEntidadFactory.getFactory("VEHICULO");
		
		Vehiculo vehiculo = vehiculoFactory.getVehiculo(this.tipo);
		vehiculo.setPlaca(this.placa);
		vehiculo.setCilindraje(this.cilindraje);
		vehiculo.setTipo(this.tipo);
		
		return vehiculo;
	}
	
	public VehiculoEntidad buildVehiculoEntidad() {
				
		return new VehiculoEntidad(this.placa, this.cilindraje, this.tipo);
	}

}
