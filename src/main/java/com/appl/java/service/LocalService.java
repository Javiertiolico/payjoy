package com.appl.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appl.java.dao.ILocalDao;
import com.appl.java.entity.StPayParametroAgencia;
import com.appl.java.entity.StPayParametroAgenciaPK;

@Service
public class LocalService implements ILocalService {
	@Autowired
	private ILocalDao dao;

	@Override
	public StPayParametroAgencia findOne(StPayParametroAgenciaPK id) {
		return dao.findOne(id);
	}

	@Override
	public List<StPayParametroAgencia> findAll() {
		return dao.findAll();
	}

	@Override
	public int save(StPayParametroAgencia object) {
		return dao.save(object);
	}
}
