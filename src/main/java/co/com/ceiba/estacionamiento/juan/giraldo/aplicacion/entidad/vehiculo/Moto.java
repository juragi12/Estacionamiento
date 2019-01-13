package co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad.vehiculo;

public class Moto extends Vehiculo {
	
	public Moto(String placa, int cilindraje, String tipo) {
		super(placa, cilindraje, tipo);
	}
	
	public Moto() {
		super();
	}

	@Override
	public void imprimirTipo() {
		System.out.println("Moto");		
	}

}
