package co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad;

public class Vehiculo {

	private String placa;
	private int cilindraje;
	private String tipo;

	public Vehiculo(String placa, int cilindraje, String tipo) {
		this.placa = placa.toUpperCase();
		this.cilindraje = cilindraje;
		this.tipo = tipo;
	}

	public Vehiculo() {

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
