package co.com.ceiba.estacionamiento.juan.giraldo.aplicacion;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.adaptador.VehiculoAdapter;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad.Vehiculo;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.excepcion.EstacionamientoExcepcion;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.helper.Temporizador;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.helper.TiempoEstadia;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.reglasnegocio.ReglaEstacionamiento;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.repositorio.SitioParqueoEntidadService;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.repositorio.VehiculoEntidadService;
import co.com.ceiba.estacionamiento.juan.giraldo.controlador.ServicioEstacionamiento;
import co.com.ceiba.estacionamiento.juan.giraldo.persistencia.entidad.SitioParqueoEntidad;
import co.com.ceiba.estacionamiento.juan.giraldo.persistencia.entidad.VehiculoEntidad;

@Component
public class ServicioEstacionamientoImpl implements ServicioEstacionamiento {

	@Autowired
	VehiculoEntidadService vehiculoEntidadService;
	
	@Autowired
	SitioParqueoEntidadService sitioParqueoEntidadService;
	
	@Autowired
	AdminEstacionamientoImpl adminEstacionamiento;
	
	/*
	 * Registra en el estacionamiento el ingreso de un vehiculo
	 */
	@Override
	public SitioParqueoEntidad registrarIngresoVehiculo(Vehiculo vehiculo) {

		boolean parquear = ReglaEstacionamiento.validarIngreso(vehiculo);

		if (!parquear) {
			throw EstacionamientoExcepcion.INGRESO_NO_AUTORIZADO.toException();
		}

		VehiculoEntidad vehiculoEnt = vehiculoEntidadService.guardar(vehiculo);

		SitioParqueoEntidad sitParEnt = adminEstacionamiento.parquearVehiculo(vehiculoEnt);

		return sitioParqueoEntidadService.parquearVehiculo(sitParEnt);
	}

	/*
	 * Registra la salida de un vehiculo y devuelve el precio a pagar
	 */
	@Override
	public int registrarSalidaVehiculo(Vehiculo vehiculo) {

		SitioParqueoEntidad sitParEntidad = sitioParqueoEntidadService.obtenerSitioParqueo(vehiculo);

		sitParEntidad.setActivo(false);
		sitParEntidad.setFechaFin(new Date());
		SitioParqueoEntidad sitParEntRet = sitioParqueoEntidadService.liberar(sitParEntidad);

		adminEstacionamiento.removerSitioParqueo(sitParEntRet);

		TiempoEstadia tiempoEstadia = Temporizador.calcularTiempoEstadia(sitParEntidad.getFechaInicio());
		return ReglaEstacionamiento.calcularPrecioParqueo(
				VehiculoAdapter.getVehiculo(sitParEntRet.getVehiculo()), tiempoEstadia);

	}

	/*
	 * Devuelve la lista de vehiculos estacionados
	 */
	@Override
	public List<Object> consultarVehiculos() {
		
		Format formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		return AdminEstacionamientoImpl.getParqueadero().stream().map(
				 temp -> {HashMap<String, String> lista = new HashMap<String, String>(); 
				 lista.put( "placa", temp.getVehiculo().getPlaca() );
				 lista.put( "tipo", temp.getVehiculo().getTipo() );
				 lista.put( "fechaInicio", formato.format( temp.getFechaInicio() ) );

				 return lista;
				 }
				).collect(Collectors.toList());
	}

}
