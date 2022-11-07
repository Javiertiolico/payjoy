package com.appl.java.dao;


import java.util.List;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.appl.java.entity.StPayMetadata;

@Repository
@Transactional
public class MetadataDao extends GenericDao<StPayMetadata> implements IMetadataDao {
	/**
     * Constructor general
     */
    public MetadataDao() {
        super();
        setClase(StPayMetadata.class);
    }
    @Override
	public StPayMetadata findOne(long id) {
		try {
			return entityManager.find(StPayMetadata.class, id);
		}catch(Exception e) {
			System.out.println("Error al encontrar registro StPayMetadata. "+e.toString());
		}
		return null;
	}
	
	@Override
	public StPayMetadata update(StPayMetadata object) {
		final Logger logger = Logger.getLogger(getClass());
		try {
			StPayMetadata _found = findOne(object.getCodMetadata());
			if(_found!=null) {
				_found.setParamDesde(_found.getParamHasta());
				_found.setParamHasta(object.getParamHasta());
				logger.info("va a actualizar stPayMetadata");
				return this.merge(_found);
			}
		}catch(Exception e) {
			//System.out.println("Error al actualizar stPayMetadata. "+e.toString());
			logger.warn("Error al actualizar stPayMetadata. "+e.toString());
		}
		return null;
	}
	
	/*@Override
	public List<StPayMetadata> usarCursor(){
		try {
			StoredProcedureQuery procedureQuery = entityManager.createStoredProcedureQuery("KS_PAY_METADATA_CURSOR.consulta_tabla",
		              StPayMetadata.class);
			procedureQuery.registerStoredProcedureParameter("cursor_datos", void.class, ParameterMode.REF_CURSOR);
			procedureQuery.execute();
			@SuppressWarnings("unchecked")
			List<StPayMetadata> resultList = procedureQuery.getResultList();
			//without Person.class arg above list of object array will be returned
			return resultList;
		}catch(Exception e) {
			System.out.println("Error al recorrer cursor. "+e.toString());
		}
		return null;
	}*/
}
