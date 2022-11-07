package com.appl.java.dao;


import org.jboss.logging.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.appl.java.entity.StPayCash;
import com.appl.java.entity.StPayCashPK;

@Repository
@Transactional
public class CashDao extends GenericDao<StPayCash> implements ICashDao {
	/**
     * Constructor general
     */
    public CashDao() {
        super();
        setClase(StPayCash.class);
    }
    @Override
	public StPayCash findOne(StPayCashPK id) {
		try {
			return entityManager.find(StPayCash.class, id);
		}catch(Exception e) {
			System.out.println("Error al encontrar registro StPayCash. "+e.toString());
		}
		return null;
	}
    
	@Override
	public int save(StPayCash object) {
		this.create(object);
        return 1;
	}
	
	@Override
	public StPayCash update(StPayCash object) {
		final Logger logger = Logger.getLogger(getClass());
		try {
			StPayCash _found = findOne(object.getId());
			if(_found!=null) {
				_found.setComission(object.getComission());
				logger.info("va a actualizar stPayCash");
				return this.merge(_found);
			}
		}catch(Exception e) {
			//System.out.println("Error al actualizar stPayCash. "+e.toString());
			logger.warn("Error al actualizar stPayCash. "+e.toString());
		}
		return null;
	}
	@Override
	public StPayCash updateAnulado(StPayCash object) {
		final Logger logger = Logger.getLogger(getClass());
		try {
			StPayCash _found = findOne(object.getId());
			if(_found!=null) {
				_found.setAnulado(object.getAnulado());
				logger.info("va a actualizar anulado en stPayCash");
				return this.merge(_found);
			}
		}catch(Exception e) {
			logger.warn("Error al actualizar anulado en stPayCash. "+e.toString());
		}
		return null;
	}
	
}
