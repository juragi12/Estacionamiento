package co.com.ceiba.estacionamiento.juan.giraldo.persistencia.repositorio;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.entidad.vehiculo.Vehiculo;
import co.com.ceiba.estacionamiento.juan.giraldo.aplicacion.repositorio.RepositorioSitioParqueo;
import co.com.ceiba.estacionamiento.juan.giraldo.persistencia.entidad.SitioParqueoEntidad;

public class RepositorioSitioParqueoImpl implements RepositorioSitioParqueo {

	private EntityManager entityManager;
	
	public static final String QUERY_BUSCAR_SITIO_PARQUEO_X_PLACA_VEHICULO = "SitioParqueo.findByPlacaVehiculo";
	public static final String PLACA = "placa";

	public RepositorioSitioParqueoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public SitioParqueoEntidad parquearVehiculo(SitioParqueoEntidad sitioParqueoEntidad) {

		this.entityManager.getTransaction().begin();
		this.entityManager.persist(sitioParqueoEntidad);
		this.entityManager.getTransaction().commit();

		return sitioParqueoEntidad;
	}

	@Override
	public SitioParqueoEntidad obtenerSitioParqueo(Vehiculo vehiculo) {

		SitioParqueoEntidad sp;
		
		Query query = entityManager.createNamedQuery(QUERY_BUSCAR_SITIO_PARQUEO_X_PLACA_VEHICULO);
		query.setParameter(PLACA, vehiculo.getPlaca());
		
		@SuppressWarnings("unchecked")
		List<Object> lista = query.getResultList();
		
		if ( ! lista.isEmpty() ) {
			Iterator<Object> iterator = lista.iterator();
			while (iterator.hasNext()) {
				sp = (SitioParqueoEntidad) iterator.next();
				
				if ( sp.isActivo() && sp.getVehiculo().getPlaca().equalsIgnoreCase(vehiculo.getPlaca()) ) {
					return sp;
				}
			}
		}		
		return null;
	}

	@Override
	public SitioParqueoEntidad liberar(SitioParqueoEntidad sitioParqueoEntidad) {

		this.entityManager.getTransaction().begin();
		this.entityManager.merge(sitioParqueoEntidad);
		this.entityManager.getTransaction().commit();

		return sitioParqueoEntidad;
	}

}
