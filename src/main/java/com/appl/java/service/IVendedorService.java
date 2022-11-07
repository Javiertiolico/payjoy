package com.appl.java.service;

import java.util.List;

import com.appl.java.entity.StPayParametroVendedor;
import com.appl.java.entity.StPayParametroVendedorPK;

public interface IVendedorService {
	StPayParametroVendedor findOne(StPayParametroVendedorPK id);
	List<StPayParametroVendedor> findAll();
	int save(StPayParametroVendedor object);
}
