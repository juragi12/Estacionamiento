package co.com.ceiba.estacionamiento.juan.giraldo.servicio;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad.vehiculo.Vehiculo;

@Path(value = "/estacionamiento")
public class EstacionamientoWS {

	
	@GET
	@Produces(value = "application/json")
	public String welcome() {
		return "Hola al Estacionamiento Juan Giraldo";
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(value = "application/json")
	@Path(value = "agregar")
	public Response agregar(Vehiculo vehiculo){
		
		return Response.ok(vehiculo).build();	 
	} 
}
