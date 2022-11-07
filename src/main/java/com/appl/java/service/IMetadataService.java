package com.appl.java.service;

import java.util.List;

import com.appl.java.entity.StPayMetadata;

public interface IMetadataService {
	StPayMetadata findOne(long id);
	List<StPayMetadata> findAll();
	StPayMetadata update(StPayMetadata object);
	
}
