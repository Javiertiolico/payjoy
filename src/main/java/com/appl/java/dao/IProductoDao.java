package com.appl.java.dao;

import java.util.List;

import com.appl.java.entity.StPayProducto;

public interface IProductoDao {
	List<StPayProducto> findAll();
	List<StPayProducto> findAllActive();
}
