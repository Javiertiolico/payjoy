package com.appl.java.dao;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.appl.java.entity.StPayProducto;

@Repository
@Transactional
public class ProductoDao extends GenericDao<StPayProducto> implements IProductoDao {
	/**
     * Constructor general
     */
    public ProductoDao() {
        super();
        setClase(StPayProducto.class);
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<StPayProducto> findAllActive() {
		final Logger log = Logger.getLogger(getClass());
		try {
			return entityManager.createQuery("from " + StPayProducto.class.getCanonicalName()+" where esactivo=1 and cod_metadata=1").getResultList();
		}catch(Exception e) {
			//System.out.println("Error al lista productos activos. "+e.toString());
			log.warn("Error al lista productos activos en ProductoDao "+e.toString());
		}
		return null;
	}
    
}
