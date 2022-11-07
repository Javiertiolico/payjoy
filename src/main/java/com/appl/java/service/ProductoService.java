package com.appl.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appl.java.dao.IProductoDao;
import com.appl.java.entity.StPayProducto;

@Service
public class ProductoService implements IProductoService {
	@Autowired
	private IProductoDao dao;

	@Override
	public List<StPayProducto> findAll() {
		return dao.findAll();
	}

	@Override
	public List<StPayProducto> findAllActive() {
		return dao.findAllActive();
	}

}
