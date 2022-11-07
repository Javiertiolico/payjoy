package com.appl.java.controller;

import java.math.BigDecimal;
//import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.appl.java.entity.StPayProducto;
import com.appl.java.entity.Producto;
import com.appl.java.service.IProductoService;
import com.appl.java.util.Util;

@RestController
public class ProductoController {
	@Autowired
	private IProductoService service;
	
	//@GetMapping (value= {"/productos", "/productos/"})
	@RequestMapping(value = {"/productos", "/productos/"},
    method = RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Producto> listProductos() {
		final Logger log = Logger.getLogger(getClass());
		try {
			List<StPayProducto> _lista = service.findAllActive();
			log.info("Productos encontrados: "+ _lista.size());
			List<Producto> _salida = new ArrayList<Producto>();
			//DecimalFormat df = new DecimalFormat("#.##");
			Util _util = new Util();
			for(StPayProducto p: _lista) {
				if(p.getSubtotal().compareTo(BigDecimal.valueOf(0))==0 || p.getTotal().compareTo(BigDecimal.valueOf(0))==0) {
					continue; // valida que tenga precio definido
				}
				_salida.add(new Producto(
						_util.bigDecimalToDouble(p.getSubtotal()),
						_util.bigDecimalToDouble(p.getIva()), 
						_util.bigDecimalToDouble(p.getTotal()), 
						p.getModelo(), 
						p.getFabricante(),
						p.getDescripcion()
				));
			}
			log.info("productos con precio>0: "+ _salida.size());
			return _salida;
		}catch(Exception e) {
			log.warn("Error al listar productos en productoCtrl. "+e.toString());
		}
		return new ArrayList<Producto>();
	}
}
