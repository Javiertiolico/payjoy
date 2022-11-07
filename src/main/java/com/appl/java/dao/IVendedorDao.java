package com.appl.java.dao;

import java.util.List;

import com.appl.java.entity.StPayParametroVendedor;
import com.appl.java.entity.StPayParametroVendedorPK;

public interface IVendedorDao {
	StPayParametroVendedor findOne(StPayParametroVendedorPK id);
	List<StPayParametroVendedor> findAll();
	int save(StPayParametroVendedor object);
}
