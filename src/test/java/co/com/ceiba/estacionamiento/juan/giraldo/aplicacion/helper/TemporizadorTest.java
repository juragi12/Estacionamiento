package co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.helper;

import static org.junit.Assert.*;

import org.junit.Test;


import java.util.Calendar;
import java.util.Date;


public class TemporizadorTest {

	private final int DIAS = 1;
	private final int HORAS = 3;
	
	@Test
	public void testCalcularTiempoEstadia() {
		
		//Arrange
		Date fechaInicio = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fechaInicio);
		calendar.add(Calendar.DAY_OF_MONTH, - DIAS);
		calendar.add(Calendar.HOUR_OF_DAY, - HORAS);
		fechaInicio = calendar.getTime();
		
		//Act
		TiempoEstadia t = Temporizador.calcularTiempoEstadia(fechaInicio);   
		
		//Assert
		assertTrue(t.getDias() == DIAS && t.getHoras() == HORAS);
	}

	@Test
	public void testCalcularTiempoEstadiaDiezHoras() {
		
		int horasEstadia = 10;
		int contDias = 1;
		int contHoras = 1;
		
		//Arrange
		Date fechaInicio = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fechaInicio);
		calendar.add(Calendar.HOUR_OF_DAY, - horasEstadia);
		fechaInicio = calendar.getTime();
		
		//Act
		TiempoEstadia t = Temporizador.calcularTiempoEstadia(fechaInicio);   
		
		//Assert
		assertTrue(t.getDias() == contDias && t.getHoras() == contHoras);
	}
	
	@Test
	public void testCalcularTiempoEstadiaCeroHoras() {
		
		int contDias = 0;
		int contHoras = 0;
		
		//Arrange
		Date fechaInicio = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fechaInicio);
		fechaInicio = calendar.getTime();
		
		//Act
		TiempoEstadia t = Temporizador.calcularTiempoEstadia(fechaInicio);   
		
		//Assert
		assertTrue(t.getDias() == contDias && t.getHoras() == contHoras);
	}
	
}
