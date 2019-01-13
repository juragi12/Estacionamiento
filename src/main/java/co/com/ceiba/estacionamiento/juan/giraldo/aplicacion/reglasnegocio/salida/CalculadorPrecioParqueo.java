package co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.reglasnegocio.salida;

import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.helper.TiempoEstadia;

public interface CalculadorPrecioParqueo {
	
	public int calcularPrecioAPagar(TiempoEstadia tiempoEstadia);

}
