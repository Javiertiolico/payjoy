package com.appl.java.service;

import java.util.List;

import com.appl.java.entity.StPayFinance;
import com.appl.java.entity.StPayFinancePK;

public interface IFinanceService {
	StPayFinance findOne(StPayFinancePK id);
	List<StPayFinance> findAll();
	int save(StPayFinance object);
	StPayFinance updateAnulado(StPayFinance object);
}
