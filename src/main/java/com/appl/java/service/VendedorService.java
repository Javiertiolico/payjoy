package com.appl.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appl.java.dao.IVendedorDao;
import com.appl.java.entity.StPayParametroVendedor;
import com.appl.java.entity.StPayParametroVendedorPK;

@Service
public class VendedorService implements IVendedorService {
	@Autowired
	private IVendedorDao dao;

	@Override
	public StPayParametroVendedor findOne(StPayParametroVendedorPK id) {
		return dao.findOne(id);
	}

	@Override
	public List<StPayParametroVendedor> findAll() {
		return dao.findAll();
	}

	@Override
	public int save(StPayParametroVendedor object) {
		return dao.save(object);
	}

}
