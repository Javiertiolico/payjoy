package com.appl.java.controller;

import java.util.List;

import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.appl.java.entity.Clerk;
import com.appl.java.entity.ResultadoClerks;
import com.appl.java.entity.StPayMetadata;
import com.appl.java.entity.StPayParametroVendedor;
import com.appl.java.entity.StPayParametroVendedorPK;
import com.appl.java.service.IMetadataService;
import com.appl.java.service.IVendedorService;
import com.appl.java.util.Util;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class VendedorController {
	@Autowired
	private IMetadataService metadataService;
	@Autowired
	private IVendedorService vendedorService;
	
	final Logger logger = Logger.getLogger(getClass());
	/**
	 * Arama url para payjoy
	 * @return
	 */
	@GetMapping (value= {"/vendedores"})
	public String getConsultaVendedores() {
		String salida="";
		try {
			String _url = "";
			StPayMetadata _config = metadataService.findOne(1);
			if(_config!=null) {
				_url = _config.getEndpoint();
				_url = _url.substring(0, _url.indexOf("&")); // quita params de fecha
				_url = _url.replaceFirst("transactions", "clerks"); // actualiza endpoint
				_url = _url.replaceFirst("\\{\\{LLAVE\\}\\}", _config.getApikey()); // asigna llave
			}
			System.out.println("url: "+_url);
			salida += _url;
			getConsulta(_url);
			logger.info("fin de proceso. vendedores en payjoy");
			salida += "fin de proceso.";
		}catch(Exception e) {
			logger.warn("Error consultar parametros de st_metadata "+e.toString());
			salida += "Error consultar parametros de st_metadata "+e.toString();
		}
		return "Consulta API de PayJoy "+salida;
	}
	/**
	 * Envia peticion a api de payjoy
	 * @param url direccion web
	 * @return json vendedores
	 */
	private String getConsulta(String url) {
		try {
			logger.info("incio de consulta vendedores a payjoy");
			CloseableHttpClient httpClient = HttpClients.custom().setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE).build();
		    HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		    requestFactory.setHttpClient(httpClient);
		    ResponseEntity<String> response = new RestTemplate(requestFactory).exchange(url , HttpMethod.GET, null, String.class);
			ObjectMapper mapper = new ObjectMapper();
			ResultadoClerks _pj = mapper.readValue(response.getBody(), ResultadoClerks.class); 
			if(_pj != null) {
				mapeaObjetos(_pj);
			}
			logger.info("fin de consulta vendedores de payjoy");
		}catch(Exception e) {
			logger.warn("Error al consultar api. "+url+". "+e.toString());
		}
		
		return "Consulta api externa";
	}
	/**
	 * Mapea vendedor y guarda en tabla
	 * @param input lista de vendedores json
	 * @return true procesado con exito, false caso contrario
	 */
	private boolean mapeaObjetos(ResultadoClerks input) {
		try {
			if(!input.isValid()) {
				logger.info("No hay venedores desde PayJoy para procesar"); 
				return false;
			}
			List<Clerk> _lista = input.getClerks();
			logger.info("cuantos vendedores "+ _lista.size());
			Util util = new Util(); // conversiones
			int len20 = 20, len100=100; //int len30=30;
			for(Clerk c : _lista) {
				StPayParametroVendedorPK pk = new StPayParametroVendedorPK();
				pk.setSalesclerkId(util.truncateStr(c.getId(), len20));
				pk.setCodMetadata(1); // default para payjoy
				StPayParametroVendedor vendedor = new StPayParametroVendedor();
				vendedor.setId(pk);
				vendedor.setSalesclerkName(util.truncateStr(c.getName(), len100));
				vendedor.setEmpresa(2); // default jaher
				vendedor.setCodTipoPersona("VEN"); // default vendedor
				vendedor.setCodVendedor("000000"); // default sistema
				StPayParametroVendedor _found = vendedorService.findOne(pk);
				if(_found==null) {
					logger.info("Vendedor nuevo. "+c.getId()+" "+c.getName());
					vendedorService.save(vendedor);
				}else {
					//System.out.println("El vendedor ya existe. "+c.getName());
				}
			}
			return true;
		}catch(Exception e) {
			logger.warn("Error al mapear json de vendedores payjoy. "+e.toString());
		}
		return false;
	}
}
