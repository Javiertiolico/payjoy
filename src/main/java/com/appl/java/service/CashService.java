package com.appl.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appl.java.dao.ICashDao;
import com.appl.java.entity.StPayCash;
import com.appl.java.entity.StPayCashPK;

@Service
public class CashService implements ICashService {
	@Autowired
	private ICashDao dao;
	
	@Override
	public List<StPayCash> findAll() {
		return dao.findAll();
	}

	@Override
	public StPayCash findOne(StPayCashPK id) {
		return dao.findOne(id);
	}

	@Override
	public int save(StPayCash object) {
		return dao.save(object);
	}

	@Override
	public StPayCash update(StPayCash object) {
		return dao.update(object);
	}

	@Override
	public StPayCash updateAnulado(StPayCash object) {
		return dao.updateAnulado(object);
	}
}
