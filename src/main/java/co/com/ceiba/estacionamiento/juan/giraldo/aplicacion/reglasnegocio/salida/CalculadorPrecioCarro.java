package co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.reglasnegocio.salida;

import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.helper.TiempoEstadia;

public class CalculadorPrecioCarro implements CalculadorPrecioParqueo {


	private static final int PRECIO_HORA = 1000 ;
	private static final int PRECIO_DIA = 8000 ;

	public int getPrecioHora() {
		return PRECIO_HORA;
	}

	public int getPrecioDia() {
		return PRECIO_DIA;
	}
	
	@Override
	public int calcularPrecioAPagar(TiempoEstadia tiempoEstadia) {
		return PRECIO_DIA*tiempoEstadia.getDias() + 
				PRECIO_HORA*tiempoEstadia.getHoras();
	}

}
