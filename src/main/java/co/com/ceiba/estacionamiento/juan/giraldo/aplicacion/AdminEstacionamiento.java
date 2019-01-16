package co.com.ceiba.estacionamiento.juan.giraldo.aplicacion;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import co.com.ceiba.estacionamiento.juan.giraldo.persistencia.entidad.SitioParqueoEntidad;
import co.com.ceiba.estacionamiento.juan.giraldo.persistencia.entidad.VehiculoEntidad;

public class AdminEstacionamiento {
	
	public static final String MOTO = "MOTO";
	public static final String CARRO = "CARRO";
	public static final int SITIOS_MOTO = 10;
	public static final int SITIOS_CARRO = 20;

	private static List<SitioParqueoEntidad> parqueadero = new ArrayList<SitioParqueoEntidad>();
	private static int contadorMotos = 0;
	private static int contadorCarros = 0;

	public AdminEstacionamiento() {
	}

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
		
		if ( vehiculoEnt.getTipo().equals(MOTO) ) {
			
			if ( contadorMotos > SITIOS_MOTO ) return null;
			contadorMotos++;	
			sitioParqueoEntidad = 
					new SitioParqueoEntidad(true, new Date(), null,
							contadorMotos , vehiculoEnt);			
		}
		
		if ( vehiculoEnt.getTipo().equals(CARRO) ) {
			
			if ( contadorCarros > SITIOS_CARRO ) return null;
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
		
		while (i.hasNext()) {
			SitioParqueoEntidad st = i.next();
			
			if ( st.getPosicion() == sitioParqueoEntidad.getPosicion() ) {
				i.remove();
			}
		}   
			
		return sitioParqueoEntidad;
	}

}
