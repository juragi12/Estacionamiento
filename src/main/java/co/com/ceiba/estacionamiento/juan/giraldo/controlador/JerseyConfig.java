package co.com.ceiba.estacionamiento.juan.giraldo.controlador;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig
{
    public JerseyConfig()
    {
        register(EstacionamientoWS.class);
    }
}
