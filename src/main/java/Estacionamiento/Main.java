package Estacionamiento;

import java.util.Calendar;
import java.util.Date;

import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.AdminEstacionamiento;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.ServicioEstacionamientoImpl;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.adaptador.VehiculoAdapter;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad.EntidadFactory;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad.CrearEntidadFactory;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad.SitioParqueo;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad.vehiculo.Moto;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad.vehiculo.Vehiculo;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.helper.Temporizador;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.helper.TiempoEstadia;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.reglasnegocio.ReglaEstacionamiento;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.reglasnegocio.ingreso.ContextoIngresoVehiculo;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.reglasnegocio.ingreso.ValidadorIngresoDias;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.reglasnegocio.ingreso.ValidadorIngresoVehiculo;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.reglasnegocio.salida.CalculadorPrecioCarro;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.reglasnegocio.salida.CalculadorPrecioFactory;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.reglasnegocio.salida.CalculadorPrecioMotoAltoCC;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.reglasnegocio.salida.CalculadorPrecioMotoBajoCC;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.reglasnegocio.salida.CalculadorPrecioParqueo;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.reglasnegocio.salida.ContextSalidaVehiculo;
import co.com.ceiba.estacionamiento.juan.giraldo.persistencia.entidad.SitioParqueoEntidad;
import co.com.ceiba.estacionamiento.juan.giraldo.persistencia.entidad.VehiculoEntidad;
import co.com.ceiba.estacionamiento.juan.giraldo.persistencia.repositorio.RepositorioFactory;
import co.com.ceiba.estacionamiento.juan.giraldo.persistencia.repositorio.RepositorioSitioParqueoImpl;
import co.com.ceiba.estacionamiento.juan.giraldo.persistencia.repositorio.RepositorioVehiculoImpl;
import co.com.ceiba.estacionamiento.juan.giraldo.servicio.EstacionamientoWS;

public class Main {

	public static void main(String[] args) {
		
	/*	
		
		// ################### Crear vehiculos ################################
		// Crea fabrica de Vehiculos
		AbstractFactory vehiculoFactory = ProcutorFactory.getFactory("VEHICULO");	
		//Crea Carro
		Vehiculo carro1 = vehiculoFactory.getVehiculo("CARRO");
		//Crea Moto
		Vehiculo moto1 = vehiculoFactory.getVehiculo("MOTO");
		carro1.imprimirTipo();
		moto1.imprimirTipo();
		// Crea fabrica de Sitios de parqueo	
		//Crea Sitio Carro
		SitioParqueo sitioCarro1 = new SitioParqueo();
		//Crea Sitio Moto
		SitioParqueo sitioMoto1 = new SitioParqueo();
		sitioCarro1.imprimirTipo();
		sitioMoto1.imprimirTipo();
			
		// ######################### Calcular precios #############################
		// Calcular valor del parqueo
		CalculadorPrecioParqueo calcPreciMoto1 = new CalculadorPrecioMotoBajoCC();
		ContextSalidaVehiculo ctx = new ContextSalidaVehiculo(calcPreciMoto1);
		TiempoEstadia tiempoEstadia = new TiempoEstadia(2,3);
		int out = ctx.calcularPrecioAPagar(tiempoEstadia);
		System.out.println("Calcula precio para Moto bajo CC 0: "+ out);
		// Calcular valor del parqueo
		CalculadorPrecioParqueo calcPreciMoto2 = new CalculadorPrecioMotoAltoCC();
		ContextSalidaVehiculo ctx1 = new ContextSalidaVehiculo(calcPreciMoto2);
		int out1 = ctx1.calcularPrecioAPagar(tiempoEstadia);
		System.out.println("Calcula precio para Moto Alto CC 1: "+ out1);
		// Calcular valor del parqueo
		CalculadorPrecioParqueo calcPreciCarro1 = new CalculadorPrecioCarro();
		ContextSalidaVehiculo ctx2 = new ContextSalidaVehiculo(calcPreciCarro1);
		int out2 = ctx2.calcularPrecioAPagar(tiempoEstadia);
		System.out.println("Calcula precio para Carro 2: "+ out2);
		
		// ##################### Uso del temporizador #################################
		Date fechaInicio = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fechaInicio);
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		calendar.add(Calendar.HOUR_OF_DAY, 3);
		//calendar.set(Calendar.MINUTE, 33);
		TiempoEstadia t = Temporizador.calcularTiempoEstadia(calendar.getTime());
		System.out.println("Se cobran : "+ t.getDias() + " Dias y " + t.getHoras() + " Horas" );        
        
        // ################# Usando repositorio Vehiculo ########################
        
		moto1.setPlaca("AAA-111");
        moto1.setTipo("MOTO");
        moto1.setCilindraje(550);
        RepositorioVehiculoImpl repositorioVeiculo = RepositorioFactory.obtenerRepositorioVehiculo();
        VehiculoEntidad vehEnt = repositorioVeiculo.guardar(moto1);
        System.out.println("Se Almacena Vehiculo : " + vehEnt.getId());
        
        // ################## Usando repositorio SitioParqueo ####################
        SitioParqueoEntidad sitioMotoEnt1 = new SitioParqueoEntidad(true, new Date(),null, 1, vehEnt);
        RepositorioSitioParqueoImpl repositorioSitioParqueo = RepositorioFactory.obtenerRepositorioSitioParqueo();
        SitioParqueoEntidad sitParEnt = repositorioSitioParqueo.parquearVehiculo(sitioMotoEnt1);
        System.out.println("Se parquea vehiculo : " + 
        		sitParEnt.getVehiculo().getPlaca() +
        		" En el sitio : " + sitParEnt.getPosicion() +
        		" Ocupado : " + sitParEnt.isActivo()
        		);
        
        // obtener el sitio de parqueo para el vehiculo calcular precio
        SitioParqueoEntidad sitParEnt2 = repositorioSitioParqueo.obtenerSitioParqueo(moto1);
        System.out.println("Se parquea vehiculo : " + 
        		sitParEnt2.getVehiculo().getPlaca() +
        		" En el sitio : " + sitParEnt2.getPosicion() +
        		" Ocupado : " + sitParEnt2.isActivo() + 
        		" Con Id de sitio "+ sitParEnt2.getId()
        		);
        
		// ############# probar AdminEstacionamiento ##########################
		AdminEstacionamiento admin = new AdminEstacionamiento();
		admin.parquearVehiculo(vehEnt);
		System.out.println("Admin Estacionamiento agregar posicion :"+ 
				admin.getParqueadero().get(0).getPosicion()
				);
		
		System.out.println("###########PARQUEADERO##############");
		for ( SitioParqueoEntidad st : admin.getParqueadero() ) {
			System.out.println("Sitio Parqueo " + st.getPosicion()
			+ " Vehiculo " + st.getVehiculo().getPlaca() );
		}
		
		admin.removerSitioParqueo(sitParEnt);		
        
        // ############### Se calcula precio para la salida ##################
        TiempoEstadia tiemEst = Temporizador.calcularTiempoEstadia(sitParEnt2.getFechaInicio());
        System.out.println("Se cobran : "+ tiemEst.getDias() + " Dias y " + tiemEst.getHoras() + " Horas" );
        
        // se crea el calculador segun el tipo de vehiculo
        Vehiculo vehiculoAparcado = VehiculoAdapter.getVehiculo(sitParEnt2.getVehiculo());
        CalculadorPrecioParqueo calcularPrecioP = 
        		CalculadorPrecioFactory.getCalculadorPrecioParqueo(vehiculoAparcado);
        
		ContextSalidaVehiculo ctxCalculador = new ContextSalidaVehiculo(calcularPrecioP);
		int precio = ctxCalculador.calcularPrecioAPagar(tiemEst);
		System.out.println("Calcula precio para Moto bajo CC 0: "+ precio);
		// Con ReglaEstacionamiento
		ReglaEstacionamiento.calcularPrecioParqueo(vehiculoAparcado, tiemEst);

		// ######################## Validar ingreso ##############################
		ValidadorIngresoVehiculo validadorIngresoMoto1 = new ValidadorIngresoDias();
		ContextEntradaVehiculo ctxValidaEntradaVeh = new ContextEntradaVehiculo(validadorIngresoMoto1);
		boolean valido = ctxValidaEntradaVeh.validaIngreso(moto1);
		System.out.println("Valida ingreso para Moto bajo CC false: "+ valido);
		// Con ReglaEstacionamiento
		ReglaEstacionamiento.validarIngreso(moto1);
		
		*/
		
//		// ## INGRESO DE VEHICULO usando el servicio ###
//		Vehiculo moto1 = new Moto();
//		moto1.setPlaca("BAA-001");
//        moto1.setTipo("MOTO");
//        moto1.setCilindraje(250);
//        
//		Vehiculo moto2 = new Moto();
//		moto2.setPlaca("BBA-002");
//		moto2.setTipo("MOTO");
//		moto2.setCilindraje(250);
//		
//		Vehiculo moto3 = new Moto();
//		moto3.setPlaca("BBA-003");
//		moto3.setTipo("MOTO");
//		moto3.setCilindraje(250);
//        
//		Vehiculo moto4 = new Moto();
//		moto4.setPlaca("BBA-003");
//		moto4.setTipo("MOTO");
//		moto4.setCilindraje(250);
		
//        ServicioEstacionamientoImpl srv = new ServicioEstacionamientoImpl();
//        
//        System.out.println("Sitio Parqueo " +
//        		srv.registrarIngresoVehiculo(moto1).getVehiculo().getPlaca());
//        
//        
//        System.out.println("Sitio Parqueo 2 " +
//        		srv.registrarIngresoVehiculo(moto2).getVehiculo().getPlaca()); 
//   
//		// ## REGISTRAR SALIDA DE VEHICULO
//		System.out.println( "Precio a pagar " +
//				srv.registrarSalidaVehiculo(moto1) );		
//		for ( SitioParqueoEntidad st : AdminEstacionamiento.getParqueadero() ) {
//			System.out.println("Sitio Parqueo " + st.getPosicion()
//			+ " Vehiculo " + st.getVehiculo().getPlaca() );
//		} 
// 
//		
//		// ## RETORNAR VEHICULOS PARQUEADOS #####
//		System.out.println("###########PARQUEADERO##############");
//		for ( SitioParqueoEntidad st : srv.consultarVehiculos() ) {
//			System.out.println("Sitio Parqueo " + st.getPosicion()
//			+ " Vehiculo " + st.getVehiculo().getPlaca() );
//		}
//		

//		EstacionamientoWS e = new EstacionamientoWS();
//		e.registrarIngreso(moto2);
//		e.registrarIngreso(moto1);
//		e.registrarIngreso(moto3);
//		System.out.println("#################");
//		
//		e.consultarParqueadero();
//		e.registrarSalida(moto1);
//		e.registrarSalida(moto2);
//		e.registrarSalida(moto4);
//		
//		System.out.println("#################");
//		e.consultarParqueadero();
		
	}

}
