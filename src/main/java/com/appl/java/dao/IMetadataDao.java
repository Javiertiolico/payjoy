package com.appl.java.dao;

import java.util.List;

import com.appl.java.entity.StPayMetadata;

public interface IMetadataDao {
	StPayMetadata findOne(long id);
	List<StPayMetadata> findAll();
	StPayMetadata update(StPayMetadata object);
	
}
