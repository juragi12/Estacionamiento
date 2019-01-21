package co.com.ceiba.estacionamiento.juan.giraldo.aplicacion;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.excepcion.EstacionamientoExcepcion;
import co.com.ceiba.estacionamiento.juan.giraldo.persistencia.entidad.SitioParqueoEntidad;
import co.com.ceiba.estacionamiento.juan.giraldo.persistencia.entidad.VehiculoEntidad;

public class AdminEstacionamiento {
	
	public static final String MOTO = "MOTO";
	public static final String CARRO = "CARRO";
	public static final int SITIOS_MOTO = 10;
	public static final int SITIOS_CARRO = 20;

	private static List<SitioParqueoEntidad> parqueadero = new ArrayList<>();
	private static int contadorMotos = 0;
	private static int contadorCarros = 0;

	public int getContadorMotos() {
		return contadorMotos;
	}

	public int getContadorCarros() {
		return contadorCarros;
	}
	
	public static List<SitioParqueoEntidad> getParqueadero() {
		return parqueadero;
	}

	public SitioParqueoEntidad parquearVehiculo(VehiculoEntidad vehiculoEnt) {

		SitioParqueoEntidad sitioParqueoEntidad = null;	

		if ( estaParqueado(vehiculoEnt) ) {
			
			throw EstacionamientoExcepcion.VEHICULO_PARQUEADO.toException();
		}
		
		if ( vehiculoEnt.getTipo().equals(MOTO) ) {
			
			if ( contadorMotos >= SITIOS_MOTO ) 
				throw EstacionamientoExcepcion.PARQUEADERO_MOTOS_COMPLETO.toException();
			
			contadorMotos++;	
			sitioParqueoEntidad = 
					new SitioParqueoEntidad(true, new Date(), null,
							contadorMotos , vehiculoEnt);			
		}
		
		if ( vehiculoEnt.getTipo().equals(CARRO) ) {
			
			if ( contadorCarros >= SITIOS_CARRO ) 
				throw EstacionamientoExcepcion.PARQUEADERO_CARROS_COMPLETO.toException();
			
			contadorCarros++;	
			sitioParqueoEntidad = 
					new SitioParqueoEntidad(true, new Date(), null,
							contadorCarros , vehiculoEnt);
		}
		
		parqueadero.add(sitioParqueoEntidad);
				
		return sitioParqueoEntidad;
	}

	public SitioParqueoEntidad removerSitioParqueo(SitioParqueoEntidad sitioParqueoEntidad) {
		
		Iterator<SitioParqueoEntidad> i = parqueadero.iterator();
		boolean sitioParqueoLiberado = false;
		
		while (i.hasNext()) {
			SitioParqueoEntidad st = i.next();			
			if ( st.getVehiculo().getPlaca() == sitioParqueoEntidad.getVehiculo().getPlaca() ) {
				i.remove();
				sitioParqueoLiberado = true;
			}
		}   
		
		if (sitioParqueoEntidad.getVehiculo().getTipo().equalsIgnoreCase(MOTO) && sitioParqueoLiberado) {
			contadorMotos--;
		}		
		if (sitioParqueoEntidad.getVehiculo().getTipo().equalsIgnoreCase(CARRO) && sitioParqueoLiberado ) {
			contadorCarros--;
		}			
		return sitioParqueoEntidad;
	}
	
	public boolean estaParqueado(VehiculoEntidad vehiculoEnt) {
		
		Iterator<SitioParqueoEntidad> i = parqueadero.iterator();
		
		while (i.hasNext()) {
			SitioParqueoEntidad st = i.next();			
			if ( st.getVehiculo().getPlaca().equalsIgnoreCase(vehiculoEnt.getPlaca()) ) {
				return true;
			}
		}  
		
		return false;
	}
	
}
