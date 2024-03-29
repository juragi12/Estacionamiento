package co.com.ceiba.estacionamiento.juan.giraldo.controlador;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad.Vehiculo;
import co.com.ceiba.estacionamiento.juan.giraldo.controlador.excepcion.EstacionamientoException;

@Component
@Path(value = "/estacionamiento")
public class EstacionamientoWS {
	
	@Autowired
	ServicioEstacionamiento servicioEstacionamiento;

	/*
	 * Validar los servicios REST
	 */
	@GET
	@Produces(value = "application/json")
	public String welcome() {
		return "Hola al Estacionamiento Juan Giraldo";
	}
	
	/*
	 * Agrega un vehiculo al parqueadero
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(value = "application/json")
	@Path(value = "registraringreso")
	public Response registrarIngreso(Vehiculo vehiculo) {

		try {
			return Response.ok(servicioEstacionamiento.registrarIngresoVehiculo(vehiculo)).build();
			
		} catch (RuntimeException e) {
			throw new EstacionamientoException(e.getMessage());
		}
	} 
	
	/*
	 * Registra la salida de un vehiculo al parqueadero y retorna el valor a pagar
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(value = "application/json")
	@Path(value = "registrarsalida")
	public Response registrarSalida(Vehiculo vehiculo){
		       
		int precioAPagar =
				servicioEstacionamiento.registrarSalidaVehiculo(vehiculo);
		
		return Response.ok(precioAPagar).build();
	}
	
	/*
	 * Consulta vehiculos en el estacionamiento
	 */
	@GET
	@Produces(value = "application/json")
	@Path(value = "consultar")
	public Response consultarParqueadero() {
				
		return Response.ok(servicioEstacionamiento.consultarVehiculos()).build();	 
		
	}	
		
}
