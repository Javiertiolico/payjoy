package com.appl.java.service;

import java.util.List;

import com.appl.java.entity.StPayCash;
import com.appl.java.entity.StPayCashPK;

public interface ICashService {
	StPayCash findOne(StPayCashPK id);
	List<StPayCash> findAll();
	int save(StPayCash object);
	StPayCash update(StPayCash object);
	StPayCash updateAnulado(StPayCash object);
}
