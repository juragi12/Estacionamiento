package co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.reglasnegocio.salida;

import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad.Vehiculo;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.excepcion.EstacionamientoExcepcion;

public final class CalculadorPrecioFactory {
	
	public static final String TIPO_VEHICULO_MOTO = "MOTO" ;
	public static final String TIPO_VEHICULO_CARRO = "CARRO" ;
	public static final int UMBRAL_CC = 500 ;
	
	private CalculadorPrecioFactory() {}
	
	/*
	 * Retorna el tipo de calculador según el tipo de vehiculo y su cc
	 */
	public static CalculadorPrecioParqueo getCalculadorPrecioParqueo(Vehiculo vehiculo) {
		
		if ( vehiculo.getTipo().equals(TIPO_VEHICULO_CARRO) ) {
			
			return new CalculadorPrecioCarro();
		}
		
		if ( vehiculo.getTipo().equals(TIPO_VEHICULO_MOTO) ) {
			
				if ( vehiculo.getCilindraje() > UMBRAL_CC ) {
					return new CalculadorPrecioMotoAltoCC();
				}   
			
				return new CalculadorPrecioMotoBajoCC();
		}
		
		throw EstacionamientoExcepcion.CALCULADOR_PRECIO_NO_DEFINIDO.toException();
	}

}
