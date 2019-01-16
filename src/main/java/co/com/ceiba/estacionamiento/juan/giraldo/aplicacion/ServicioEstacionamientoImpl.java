package co.com.ceiba.estacionamiento.juan.giraldo.aplicacion;

import java.util.Date;
import java.util.List;

import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad.vehiculo.Vehiculo;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.helper.Temporizador;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.helper.TiempoEstadia;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.reglasnegocio.ReglaEstacionamiento;
import co.com.ceiba.estacionamiento.juan.giraldo.persistencia.entidad.SitioParqueoEntidad;
import co.com.ceiba.estacionamiento.juan.giraldo.persistencia.entidad.VehiculoEntidad;
import co.com.ceiba.estacionamiento.juan.giraldo.persistencia.repositorio.RepositorioFactory;
import co.com.ceiba.estacionamiento.juan.giraldo.persistencia.repositorio.RepositorioSitioParqueoImpl;
import co.com.ceiba.estacionamiento.juan.giraldo.persistencia.repositorio.RepositorioVehiculoImpl;
import co.com.ceiba.estacionamiento.juan.giraldo.servicio.ServicioEstacionamiento;

public class ServicioEstacionamientoImpl implements ServicioEstacionamiento {

	public static final String INGRESO_NO_AUTORIZADO = "No está autorizado para ingresar";

	/*
	 * Registra en el estacionamiento el ingreso de un vehiculo
	 */
	@Override
	public SitioParqueoEntidad registrarIngresoVehiculo(Vehiculo vehiculo) {

		boolean parquear = ReglaEstacionamiento.validarIngreso(vehiculo);

		if (!parquear) {
			throw new IllegalArgumentException(INGRESO_NO_AUTORIZADO);
		}

		RepositorioVehiculoImpl repositorioVeiculo = RepositorioFactory.obtenerRepositorioVehiculo();
		VehiculoEntidad vehiculoEnt = repositorioVeiculo.guardar(vehiculo);

		AdminEstacionamiento adminEstacionamiento = new AdminEstacionamiento();
		SitioParqueoEntidad sitParEnt = adminEstacionamiento.parquearVehiculo(vehiculoEnt);

		RepositorioSitioParqueoImpl repositorioSitioParqueo = RepositorioFactory.obtenerRepositorioSitioParqueo();
		SitioParqueoEntidad sitParEntRep = repositorioSitioParqueo.parquearVehiculo(sitParEnt);

		return sitParEntRep;
	}

	/*
	 * Registra la salida de un vehiculo y devuelve el precio a pagar
	 */
	@Override
	public int registrarSalidaVehiculo(Vehiculo vehiculo) {

		RepositorioSitioParqueoImpl repositorioSitioParqueo = RepositorioFactory.obtenerRepositorioSitioParqueo();
		SitioParqueoEntidad sitParEntidad = repositorioSitioParqueo.obtenerSitioParqueo(vehiculo);

		sitParEntidad.setActivo(false);
		sitParEntidad.setFechaFin(new Date());
		SitioParqueoEntidad sitParEntRet = repositorioSitioParqueo.liberar(sitParEntidad);

		AdminEstacionamiento adminEstacionamiento = new AdminEstacionamiento();
		adminEstacionamiento.removerSitioParqueo(sitParEntRet);

		TiempoEstadia tiempoEstadia = Temporizador.calcularTiempoEstadia(sitParEntidad.getFechaInicio());
		int precioAPagar = ReglaEstacionamiento.calcularPrecioParqueo(vehiculo, tiempoEstadia);

		return precioAPagar;
	}

	/*
	 * Devuelve la lista de vehiculos estacionados
	 */
	@Override
	public List<SitioParqueoEntidad> consultarVehiculos() {
		return AdminEstacionamiento.getParqueadero();
	}

}
