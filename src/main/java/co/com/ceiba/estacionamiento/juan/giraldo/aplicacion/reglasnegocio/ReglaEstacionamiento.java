package co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.reglasnegocio;

import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad.Vehiculo;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.helper.TiempoEstadia;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.reglasnegocio.ingreso.ContextoIngresoVehiculo;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.reglasnegocio.ingreso.ValidadorIngresoDias;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.reglasnegocio.ingreso.ValidadorIngresoVehiculo;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.reglasnegocio.salida.CalculadorPrecioFactory;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.reglasnegocio.salida.CalculadorPrecioParqueo;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.reglasnegocio.salida.ContextSalidaVehiculo;

public final class ReglaEstacionamiento {

	private ReglaEstacionamiento() {}
	
	public static boolean validarIngreso(Vehiculo vehiculo) {

		ValidadorIngresoVehiculo validadorIngreso = new ValidadorIngresoDias();
		ContextoIngresoVehiculo ctxValidaEntradaVeh = new ContextoIngresoVehiculo(validadorIngreso);
		return ctxValidaEntradaVeh.validaIngreso(vehiculo);
	}
	
	public static int calcularPrecioParqueo(Vehiculo vehiculo, TiempoEstadia tiempoEstadia) {
	
        CalculadorPrecioParqueo calculadorPrecioP = 
        		CalculadorPrecioFactory.getCalculadorPrecioParqueo(vehiculo);
  
		ContextSalidaVehiculo ctxCalculador = new ContextSalidaVehiculo(calculadorPrecioP);
		return ctxCalculador.calcularPrecioAPagar(tiempoEstadia);
		
	}
}
