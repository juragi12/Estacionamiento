package co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.excepcion;

public enum EstacionamientoExcepcion {

	INGRESO_NO_AUTORIZADO("No esta autorizado a ingresar"),
	VEHICULO_PARQUEADO("El vehiculo esta activo en el estacionamiento"),
	PARQUEADERO_MOTOS_COMPLETO("Estacionamiento de Motos lleno"),
	PARQUEADERO_CARROS_COMPLETO("Estacionamiento de Carros lleno"),

	TIPO_VEHICULO_NO_DEFINIDO("Se especifico un tipo de vehiculo no definido"),
	CALCULADOR_PRECIO_NO_DEFINIDO("Se especifico un tipo de calculador de precio no definido");;
	
	private final String mensaje;

	EstacionamientoExcepcion(final String s) {
		mensaje = s;
	}

	public RuntimeException toException() {
		return new RuntimeException(mensaje);
	}
	
	@Override
	public String toString() {
		return mensaje;
	}
}
