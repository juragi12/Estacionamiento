package co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.helper;

import static org.junit.Assert.*;

import org.junit.Test;

public class TiempoEstadiaTest {

	private static final int DIAS = 1;
	private static final int HORAS = 3;
	TiempoEstadia tiempoEstadia = new TiempoEstadia(DIAS, HORAS);
	
	
	@Test
	public void testGetDias() {
		assertTrue(tiempoEstadia.getDias() == DIAS );
	}

	@Test
	public void testGetHoras() {
		assertTrue(tiempoEstadia.getHoras()== HORAS );
	}

}
