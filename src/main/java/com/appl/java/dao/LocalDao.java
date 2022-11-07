package com.appl.java.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.appl.java.entity.StPayParametroAgencia;
import com.appl.java.entity.StPayParametroAgenciaPK;

@Repository
@Transactional
public class LocalDao extends GenericDao<StPayParametroAgencia> implements ILocalDao {
	/**
     * Constructor general
     */
    public LocalDao() {
        super();
        setClase(StPayParametroAgencia.class);
    }

	@Override
	public StPayParametroAgencia findOne(StPayParametroAgenciaPK id) {
		try {
			return entityManager.find(StPayParametroAgencia.class, id);
		}catch(Exception e) {
			System.out.println("Error al encontrar registro parametro agencia. "+e.toString());
		}
		return null;
	}

	@Override
	public int save(StPayParametroAgencia object) {
		this.create(object);
        return 1;
	}
}
