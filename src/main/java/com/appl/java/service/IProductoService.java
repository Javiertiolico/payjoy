package com.appl.java.service;

import java.util.List;

import com.appl.java.entity.StPayProducto;

public interface IProductoService {
	List<StPayProducto> findAll();
	List<StPayProducto> findAllActive();
}
