package co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.reglasnegocio.salida;

import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.helper.TiempoEstadia;

public class CalculadorPrecioMotoBajoCC implements CalculadorPrecioParqueo {

	private final int precioHora = 500 ;
	private final int precioDia = 4000 ;

	public int getPrecioHora() {
		return precioHora;
	}

	public int getPrecioDia() {
		return precioDia;
	}
	
	@Override
	public int calcularPrecioAPagar(TiempoEstadia tiempoEstadia) {
		return precioDia*tiempoEstadia.getDias() + 
				precioHora*tiempoEstadia.getHoras();
	}

}
