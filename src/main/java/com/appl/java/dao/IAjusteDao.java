package com.appl.java.dao;

import java.util.List;

import com.appl.java.entity.StPayAjuste;
import com.appl.java.entity.StPayAjustePK;

public interface IAjusteDao {
	StPayAjuste findOne(StPayAjustePK id);
	List<StPayAjuste> findAll();
	int save(StPayAjuste object);
	StPayAjuste update(StPayAjuste object);
}
