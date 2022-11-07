package com.appl.java.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.appl.java.entity.StPayParametroVendedor;
import com.appl.java.entity.StPayParametroVendedorPK;

@Repository
@Transactional
public class VendedorDao extends GenericDao<StPayParametroVendedor> implements IVendedorDao {
	/**
     * Constructor general
     */
    public VendedorDao() {
        super();
        setClase(StPayParametroVendedor.class);
    }

	@Override
	public StPayParametroVendedor findOne(StPayParametroVendedorPK id) {
		try {
			return entityManager.find(StPayParametroVendedor.class, id);
		}catch(Exception e) {
			System.out.println("Error al encontrar registro parametro vendedor. "+e.toString());
		}
		return null;
	}

	@Override
	public int save(StPayParametroVendedor object) {
		this.create(object);
        return 1;
	}
}
