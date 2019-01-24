package co.com.ceiba.estacionamiento.juan.giraldo.persistencia.entidad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Vehiculo")
public class VehiculoEntidad {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String placa;
	private int cilindraje;
	private String tipo;

	public VehiculoEntidad(String placa, int cilindraje, String tipo) {
		this.placa = placa;
		this.cilindraje = cilindraje;
		this.tipo = tipo;
	}

	public VehiculoEntidad() {

	}
	
	public Long getId() {
		return id;
	}

	public String getPlaca() {
		return placa;
	}

	public int getCilindraje() {
		return cilindraje;
	}

	public String getTipo() {
		return tipo;
	}	
	
	public void setId(Long id) {
		this.id = id;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public void setCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
