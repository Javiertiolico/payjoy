package com.appl.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appl.java.dao.IMetadataDao;
import com.appl.java.entity.StPayMetadata;

@Service
public class MetadataService implements IMetadataService {
	
	@Autowired
	private IMetadataDao dao;

	@Override
	public StPayMetadata findOne(long id) {
		return dao.findOne(id);
	}

	@Override
	public List<StPayMetadata> findAll() {
		return dao.findAll();
	}

	@Override
	public StPayMetadata update(StPayMetadata object) {
		return dao.update(object);
	}
	
}
