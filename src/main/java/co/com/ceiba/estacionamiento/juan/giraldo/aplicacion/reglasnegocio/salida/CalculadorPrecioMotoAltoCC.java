package co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.reglasnegocio.salida;

import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.helper.TiempoEstadia;

public class CalculadorPrecioMotoAltoCC implements CalculadorPrecioParqueo {

	private static final int PRECIO_HORA = 500 ;
	private static final int PRECIO_DIA = 4000 ;
	private static final int RECARGO = 2000 ;
	
	public int getPrecioHora() {
		return PRECIO_HORA;
	}

	public int getPrecioDia() {
		return PRECIO_DIA;
	}

	public int getRecargo() {
		return RECARGO;
	}
	
	@Override
	public int calcularPrecioAPagar(TiempoEstadia tiempoEstadia) {

		return PRECIO_DIA*tiempoEstadia.getDias() + 
				PRECIO_HORA*tiempoEstadia.getHoras() + 
				RECARGO;
	}

}
