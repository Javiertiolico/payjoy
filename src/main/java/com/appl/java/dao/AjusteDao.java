package com.appl.java.dao;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.appl.java.entity.StPayAjuste;
import com.appl.java.entity.StPayAjustePK;

@Repository
@Transactional
public class AjusteDao extends GenericDao<StPayAjuste> implements IAjusteDao {
	/**
     * Constructor general
     */
    public AjusteDao() {
        super();
        setClase(StPayAjuste.class);
    }
    @Override
	public StPayAjuste findOne(StPayAjustePK id) {
		try {
			return entityManager.find(StPayAjuste.class, id);
		}catch(Exception e) {
			System.out.println("Error al encontrar registro StPayAjuste. "+e.toString());
		}
		return null;
	}
	
	@Override
	public StPayAjuste update(StPayAjuste object) {
		final Logger logger = Logger.getLogger(getClass());
		try {
			StPayAjuste _found = findOne(object.getId());
			if(_found!=null) {
				logger.info("va a actualizar stPayAjuste");
				return this.merge(_found);
			}
		}catch(Exception e) {
			logger.warn("Error al actualizar stPayAjuste. "+e.toString());
		}
		return null;
	}
	@Override
	public int save(StPayAjuste object) {
		this.create(object);
        return 1;
	}
	
}