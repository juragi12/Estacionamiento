package co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.reglasnegocio.salida;

import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.helper.TiempoEstadia;

public class CalculadorPrecioCarro implements CalculadorPrecioParqueo {


	private final int precioHora = 1000 ;
	private final int precioDia = 8000 ;

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
