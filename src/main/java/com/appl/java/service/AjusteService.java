package com.appl.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appl.java.dao.IAjusteDao;
import com.appl.java.entity.StPayAjustePK;
import com.appl.java.entity.StPayAjuste;

@Service
public class AjusteService implements IAjusteService {
	@Autowired
	private IAjusteDao dao;

	@Override
	public StPayAjuste findOne(StPayAjustePK id) {
		return dao.findOne(id);
	}

	@Override
	public List<StPayAjuste> findAll() {
		return dao.findAll();
	}

	@Override
	public StPayAjuste update(StPayAjuste object) {
		return dao.update(object);
	}

	@Override
	public int save(StPayAjuste object) {
		return dao.save(object);
	}
}
