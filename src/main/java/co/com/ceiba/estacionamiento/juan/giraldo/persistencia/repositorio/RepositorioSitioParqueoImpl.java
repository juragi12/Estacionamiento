package co.com.ceiba.estacionamiento.juan.giraldo.persistencia.repositorio;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad.SitioParqueo;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad.vehiculo.Vehiculo;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.repositorio.RepositorioSitioParqueo;
import co.com.ceiba.estacionamiento.juan.giraldo.persistencia.adaptador.SitioParqueoAdapter;
import co.com.ceiba.estacionamiento.juan.giraldo.persistencia.entidad.SitioParqueoEntidad;
import co.com.ceiba.estacionamiento.juan.giraldo.persistencia.entidad.VehiculoEntidad;

public class RepositorioSitioParqueoImpl implements RepositorioSitioParqueo {

	private EntityManager entityManager;
	
	public RepositorioSitioParqueoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public SitioParqueoEntidad parquearVehiculo(SitioParqueo sitioParqueo, VehiculoEntidad vehiculoEntidad) {
		
		this.entityManager.getTransaction().begin();
		SitioParqueoEntidad sitioParqueoEntidad = 
				SitioParqueoAdapter.getSitioParqueoEntidad(sitioParqueo, vehiculoEntidad);
		this.entityManager.persist(sitioParqueoEntidad);
		
//        System.out.println(" sitioParqueoEntidad : " + sitioParqueoEntidad.getId() );
		
		this.entityManager.getTransaction().commit();
//        SitioParqueoEntidad sP =  this.entityManager.find(SitioParqueoEntidad.class, 2);        
//        System.out.println("Se Almacena Sitio de parqueo : " + sP.getPosicion() +
//        		" El vehiculo con placa: " + sP.getVehiculo().getPlaca());

		return sitioParqueoEntidad;
	}

	@Override
	public SitioParqueoEntidad obtenerSitioParqueo(Vehiculo vehiculo) {
		
		Query query = entityManager.createNamedQuery("SitioParqueo.findByPlacaVehiculo");
		query.setParameter("placa", vehiculo.getPlaca());
		return (SitioParqueoEntidad) query.getSingleResult();

	}

	@Override
	public SitioParqueoEntidad liberar(SitioParqueo sitioParqueo) {
		// TODO Auto-generated method stub
		return null;
	}

}
