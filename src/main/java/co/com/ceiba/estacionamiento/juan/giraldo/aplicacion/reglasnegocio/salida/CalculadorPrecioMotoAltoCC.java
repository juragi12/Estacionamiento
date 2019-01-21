package co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.reglasnegocio.salida;

import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.helper.TiempoEstadia;

public class CalculadorPrecioMotoAltoCC implements CalculadorPrecioParqueo {

	private final int precioHora = 500 ;
	private final int precioDia = 4000 ;
	private final int recargo = 2000 ;
	
	public int getPrecioHora() {
		return precioHora;
	}

	public int getPrecioDia() {
		return precioDia;
	}

	public int getRecargo() {
		return recargo;
	}
	
	@Override
	public int calcularPrecioAPagar(TiempoEstadia tiempoEstadia) {

		return precioDia*tiempoEstadia.getDias() + 
				precioHora*tiempoEstadia.getHoras() + 
				recargo;
	}

}
