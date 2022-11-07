package com.appl.java.service;

import java.util.List;

import com.appl.java.entity.StPayParametroAgencia;
import com.appl.java.entity.StPayParametroAgenciaPK;

public interface ILocalService {
	StPayParametroAgencia findOne(StPayParametroAgenciaPK id);
	List<StPayParametroAgencia> findAll();
	int save(StPayParametroAgencia object);
}
