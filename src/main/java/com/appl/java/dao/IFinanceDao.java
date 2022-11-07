package com.appl.java.dao;

import java.util.List;

import com.appl.java.entity.StPayFinance;
import com.appl.java.entity.StPayFinancePK;

public interface IFinanceDao {
	StPayFinance findOne(StPayFinancePK id);
	List<StPayFinance> findAll();
	int save(StPayFinance object);
	StPayFinance updateAnulado(StPayFinance object);
}
