package co.com.ceiba.estacionamiento.juan.giraldo.controlador.excepcion;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

@Provider
public class EstacionamientoException extends WebApplicationException  {

	private static final long serialVersionUID = 1L;
	
	public EstacionamientoException() {	}
	
	public EstacionamientoException( String mensaje ) {	
		super(Response.status(Status.BAD_REQUEST).entity(mensaje)
                .type(MediaType.APPLICATION_JSON).build());
	}
}