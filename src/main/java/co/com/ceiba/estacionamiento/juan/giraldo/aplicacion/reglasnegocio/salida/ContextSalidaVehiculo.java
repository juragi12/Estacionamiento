package co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.reglasnegocio.salida;

import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.helper.TiempoEstadia;

public class ContextSalidaVehiculo {

	   private CalculadorPrecioParqueo calculadorprecioParqueo;
	   
	   public ContextSalidaVehiculo() {
		   
	   }

	   public ContextSalidaVehiculo(CalculadorPrecioParqueo calculadorprecioParqueo){
	      this.calculadorprecioParqueo = calculadorprecioParqueo;
	   }

	   public int calcularPrecioAPagar(TiempoEstadia tiempoEstadia){
	      return calculadorprecioParqueo.calcularPrecioAPagar(tiempoEstadia);
	   }
	   
	   public void setContextSalidaVehiculo(CalculadorPrecioParqueo calculadorprecioParqueo){
		   this.calculadorprecioParqueo = calculadorprecioParqueo;
	   }
}
