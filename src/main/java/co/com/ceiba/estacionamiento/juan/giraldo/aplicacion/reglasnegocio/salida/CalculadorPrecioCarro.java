package co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.reglasnegocio.salida;

import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.helper.TiempoEstadia;

public class CalculadorPrecioCarro implements CalculadorPrecioParqueo {

	public static final int PRECIO_HORA = 1000 ;
	public static final int PRECIO_DIA = 8000 ;
	
	@Override
	public int calcularPrecioAPagar(TiempoEstadia tiempoEstadia) {
		return PRECIO_DIA*tiempoEstadia.getDias() + 
				PRECIO_HORA*tiempoEstadia.getHoras();
	}

}
