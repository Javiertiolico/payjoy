package com.appl.java.dao;

import java.util.List;

import com.appl.java.entity.StPayParametroAgencia;
import com.appl.java.entity.StPayParametroAgenciaPK;

public interface ILocalDao {
	StPayParametroAgencia findOne(StPayParametroAgenciaPK id);
	List<StPayParametroAgencia> findAll();
	int save(StPayParametroAgencia object);
}
