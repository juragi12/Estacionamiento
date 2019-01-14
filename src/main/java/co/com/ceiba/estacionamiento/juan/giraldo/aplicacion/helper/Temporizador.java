package co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.helper;

import java.util.Calendar;
import java.util.Date;

public class Temporizador {
	
	public static final int HORAS_DIA = 24 ;
	public static final int TIEMPO_EN_HORAS = (1000 * 60 * 60) ;
	public static final int HORAS_DIA_PARQUEO = 9 ;
	
	public static TiempoEstadia calcularTiempoEstadia(Date fechaInicio) {
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fechaInicio);
	
		Date fechaFin = new Date();
	
		double diferenciaEnMiles = (fechaInicio.getTime() - fechaFin.getTime());
		long difEnHoras = (long) (  Math.ceil( diferenciaEnMiles / ((double) TIEMPO_EN_HORAS) ) ) ;
		
		long dias = difEnHoras/HORAS_DIA;
		long horasRestantes = difEnHoras - dias*HORAS_DIA;
		long horas = horasRestantes;
		
		while(horasRestantes > HORAS_DIA_PARQUEO) {
			dias++;
			horas = horasRestantes-HORAS_DIA_PARQUEO;			
			horasRestantes = horasRestantes-HORAS_DIA_PARQUEO;
		}	
		
		TiempoEstadia tiempoEstadia = new TiempoEstadia((int) dias, (int) horas); 
		
		return tiempoEstadia;
	}

}
