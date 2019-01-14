package co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.reglasnegocio;

import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad.vehiculo.Vehiculo;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.helper.TiempoEstadia;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.reglasnegocio.ingreso.ContextEntradaVehiculo;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.reglasnegocio.ingreso.ValidadorIngresoDias;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.reglasnegocio.ingreso.ValidadorIngresoVehiculo;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.reglasnegocio.salida.CalculadorPrecioFactory;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.reglasnegocio.salida.CalculadorPrecioParqueo;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.reglasnegocio.salida.ContextSalidaVehiculo;

public class ReglaEstacionamiento {

	public static boolean validarIngreso(Vehiculo vehiculo) {

		ValidadorIngresoVehiculo validadorIngreso = new ValidadorIngresoDias();
		ContextEntradaVehiculo ctxValidaEntradaVeh = new ContextEntradaVehiculo(validadorIngreso);
		boolean valido = ctxValidaEntradaVeh.validaIngreso(vehiculo);
		return valido;
	}
	
	public static int calcularPrecioParqueo(Vehiculo vehiculo, TiempoEstadia tiempoEstadia) {
	
        CalculadorPrecioParqueo calculadorPrecioP = 
        		CalculadorPrecioFactory.getCalculadorPrecioParqueo(vehiculo);
  
		ContextSalidaVehiculo ctxCalculador = new ContextSalidaVehiculo(calculadorPrecioP);
		int precio = ctxCalculador.calcularPrecioAPagar(tiempoEstadia);
		return precio;
		
	}
}
