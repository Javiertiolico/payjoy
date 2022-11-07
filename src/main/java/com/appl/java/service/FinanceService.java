package com.appl.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appl.java.dao.IFinanceDao;
import com.appl.java.entity.StPayFinance;
import com.appl.java.entity.StPayFinancePK;

@Service
public class FinanceService implements IFinanceService {
	
	@Autowired
	private IFinanceDao dao;

	@Override
	public StPayFinance findOne(StPayFinancePK id) {
		return dao.findOne(id);
	}

	@Override
	public List<StPayFinance> findAll() {
		return dao.findAll();
	}

	@Override
	public int save(StPayFinance object) {
		return dao.save(object);
	}

	@Override
	public StPayFinance updateAnulado(StPayFinance object) {
		return dao.updateAnulado(object);
	}

}
