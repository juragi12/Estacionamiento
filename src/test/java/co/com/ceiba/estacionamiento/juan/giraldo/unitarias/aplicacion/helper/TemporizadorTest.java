package co.com.ceiba.estacionamiento.juan.giraldo.unitarias.aplicacion.helper;

import static org.junit.Assert.*;

import org.junit.Test;

import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.helper.Temporizador;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.helper.TiempoEstadia;

import java.util.Calendar;
import java.util.Date;


public class TemporizadorTest {


	
	@Test
	public void testCalcularTiempoEstadia() {
		
		int dias = 1;
		int horas = 4;
		int minutosEstadia = 1;
		
		//Arrange
		Date fechaInicio = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fechaInicio);
		calendar.add(Calendar.DAY_OF_MONTH, - dias);
		calendar.add(Calendar.HOUR_OF_DAY, - horas);
		calendar.add(Calendar.MINUTE, + minutosEstadia);
		fechaInicio = calendar.getTime();
		
		//Act
		TiempoEstadia t = Temporizador.calcularTiempoEstadia(fechaInicio);   
		
		//Assert
		assertTrue(t.getDias() == dias && t.getHoras() == horas);
	}

	@Test
	public void testCalcularTiempoEstadiaDiezHoras() {
		
		int horasEstadia = 10;
		int contDias = 1;
		int contHoras = 0;
		
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
	public void testCalcularTiempoEstadiaUnaHorasCuandoEstaMenosDeHora() {
		
		int contDias = 0;
		int contHoras = 1;
		int horasEstadia = 1;
		int minutosEstadia = 1;
		
		//Arrange
		Date fechaInicio = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fechaInicio);
		calendar.add(Calendar.HOUR_OF_DAY, - horasEstadia);
		calendar.add(Calendar.MINUTE, + minutosEstadia);
		fechaInicio = calendar.getTime();
		
		//Act
		TiempoEstadia t = Temporizador.calcularTiempoEstadia(fechaInicio);   
		
		//Assert
		assertTrue(t.getDias() == contDias && t.getHoras() == contHoras);
	}
	
}
