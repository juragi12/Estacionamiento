package co.com.ceiba.estacionamiento.juan.giraldo.controlador.excepcion;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


@Provider
public class EstacionamientoException extends Exception  implements ExceptionMapper<EstacionamientoException> {

	private static final long serialVersionUID = 1L;
	
	public EstacionamientoException() {	}
	
	public EstacionamientoException( String string ) {	
		super(string);
	}

	@Override
	public Response toResponse(EstacionamientoException exception) {
        return Response.status(Status.BAD_REQUEST).entity(exception.getMessage())
                .type(MediaType.APPLICATION_JSON).build();
	}
}