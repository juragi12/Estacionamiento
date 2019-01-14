package co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.reglasnegocio.salida;

import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.helper.TiempoEstadia;

public class CalculadorPrecioMotoAltoCC implements CalculadorPrecioParqueo {

	public final int PRECIO_HORA = 500 ;
	public final int PRECIO_DIA = 4000 ;
	public final int RECARGO = 2000 ;
	
	@Override
	public int calcularPrecioAPagar(TiempoEstadia tiempoEstadia) {

		return PRECIO_DIA*tiempoEstadia.getDias() + 
				PRECIO_HORA*tiempoEstadia.getHoras() + 
				RECARGO;
	}

}
