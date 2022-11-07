package com.appl.java.dao;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.appl.java.entity.StPayFinance;
import com.appl.java.entity.StPayFinancePK;

@Repository
@Transactional
public class FinanceDao extends GenericDao<StPayFinance> implements IFinanceDao {
	
	/**
     * Constructor general
     */
    public FinanceDao() {
        super();
        setClase(StPayFinance.class);
    }

	@Override
	public StPayFinance findOne(StPayFinancePK id) {
		try {
			return entityManager.find(StPayFinance.class, id);
		}catch(Exception e) {
			System.out.println("Error al encontrar registro finance. "+e.toString());
		}
		return null;
	}

	@Override
	public int save(StPayFinance object) {
		this.create(object);
        return 1;
	}
	@Override
	public StPayFinance updateAnulado(StPayFinance object) {
		final Logger logger = Logger.getLogger(getClass());
		try {
			StPayFinance _found = findOne(object.getId());
			if(_found!=null) {
				_found.setAnulado(object.getAnulado());
				logger.info("va a actualizar anulado en stPayFinance");
				return this.merge(_found);
			}
		}catch(Exception e) {
			logger.warn("Error al actualizar anulado en stPayFinance. "+e.toString());
		}
		return null;
	}

}
