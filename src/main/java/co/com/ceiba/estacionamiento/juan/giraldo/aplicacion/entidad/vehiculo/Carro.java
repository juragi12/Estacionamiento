package co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad.vehiculo;

public class Carro extends Vehiculo {

	public Carro(String placa, int cilindraje, String tipo) {
		super(placa, cilindraje, tipo);
	}

	public Carro() {
		super();
	}
	
	@Override
	public void imprimirTipo() {
		System.out.println("Carro");	
	}

}
