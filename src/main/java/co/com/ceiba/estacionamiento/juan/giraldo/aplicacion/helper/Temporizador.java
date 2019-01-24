package co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.helper;

import java.util.Calendar;
import java.util.Date;

public final class Temporizador {
	
	public static final int HORAS_DIA = 24 ;
	public static final double TIEMPO_EN_HORAS = (1000 * 60 * 60) ;
	public static final int HORAS_DIA_PARQUEO = 9 ;
	
	private Temporizador() {
	}
	
	public static TiempoEstadia calcularTiempoEstadia(Date fechaInicio) {
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fechaInicio);
	
		Date fechaFin = new Date();
		double diferenciaEnMiles = ( fechaFin.getTime() - fechaInicio.getTime() );
		long difEnHoras = (long) Math.ceil( diferenciaEnMiles / TIEMPO_EN_HORAS  ) ;
		
		long dias = difEnHoras/HORAS_DIA;
		long horas = difEnHoras - dias*HORAS_DIA;
		
		if(horas > HORAS_DIA_PARQUEO) {
			dias++;
			horas = 0;
		}	
		
		return new TiempoEstadia((int) dias, (int) horas);
	}

}
