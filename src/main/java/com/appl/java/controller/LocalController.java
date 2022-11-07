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

import com.appl.java.entity.Merchant;
import com.appl.java.entity.ResultadoMerchants;
import com.appl.java.entity.StPayMetadata;
import com.appl.java.entity.StPayParametroAgencia;
import com.appl.java.entity.StPayParametroAgenciaPK;
import com.appl.java.service.IMetadataService;
import com.appl.java.service.ILocalService;
import com.appl.java.util.Util;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class LocalController {
	@Autowired
	private IMetadataService metadataService;
	@Autowired
	private ILocalService localService;
	
	final Logger logger = Logger.getLogger(getClass());
	/**
	 * Arama url para payjoy
	 * @return
	 */
	@GetMapping (value= {"/agencias"})
	public String getConsultaLocales() {
		String salida="";
		try {
			String _url = "";
			StPayMetadata _config = metadataService.findOne(1);
			if(_config!=null) {
				_url = _config.getEndpoint();
				_url = _url.substring(0, _url.indexOf("&")); // quita params de fecha
				_url = _url.replaceFirst("transactions", "merchants"); // actualiza endpoint
				_url = _url.replaceFirst("\\{\\{LLAVE\\}\\}", _config.getApikey()); // asigna llave
			}
			System.out.println("url: "+_url);
			salida += _url;
			getConsulta(_url);
			logger.info("fin de proceso. agencias en payjoy");
			salida += ".fin de proceso.";
		}catch(Exception e) {
			logger.warn("Error consultar parametros de st_metadata "+e.toString());
			salida += "Error consultar parametros de st_metadata "+e.toString();
		}
		return "Consulta API de PayJoy "+salida;
	}
	/**
	 * Envia peticion a api de payjoy
	 * @param url direccion web
	 * @return json locales
	 */
	private String getConsulta(String url) {
		try {
			logger.info("incio de consulta agencias a payjoy");
			CloseableHttpClient httpClient = HttpClients.custom().setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE).build();
		    HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		    requestFactory.setHttpClient(httpClient);
		    ResponseEntity<String> response = new RestTemplate(requestFactory).exchange(url , HttpMethod.GET, null, String.class);
			ObjectMapper mapper = new ObjectMapper();
			ResultadoMerchants _pj = mapper.readValue(response.getBody(), ResultadoMerchants.class); 
			if(_pj != null) {
				mapeaObjetos(_pj);
			}
			logger.info("fin de consulta agencias de payjoy");
		}catch(Exception e) {
			logger.warn("Error al consultar api. "+url+". "+e.toString());
		}
		
		return "Consulta api externa";
	}
	/**
	 * Mapea local y guarda en tabla
	 * @param input lista de agencias json
	 * @return true procesado con exito, false caso contrario
	 */
	private boolean mapeaObjetos(ResultadoMerchants input) {
		try {
			if(!input.isValid()) {
				logger.info("No hay venedores desde PayJoy para procesar"); 
				return false;
			}
			List<Merchant> _lista = input.getMerchants();
			logger.info("cuantas agencias "+ _lista.size());
			Util util = new Util(); // conversiones
			int len20 = 20, len100=100; //int len30=30;
			for(Merchant l : _lista) {
				StPayParametroAgenciaPK pk = new StPayParametroAgenciaPK();
				pk.setMerchantId(util.truncateStr(l.getId(), len20));
				pk.setCodMetadata(1); // default para payjoy
				StPayParametroAgencia local = new StPayParametroAgencia();
				local.setId(pk);
				local.setMerchantName(util.truncateStr(l.getName(), len100));
				local.setEmpresa(2); // default jaher
				local.setCodAgencia(0); //default matriz
				StPayParametroAgencia _found = localService.findOne(pk);
				if(_found==null) {
					logger.info("Agencia nueva. "+l.getId()+" "+l.getName());
					localService.save(local);
				}else {
					//System.out.println("agencia ya existe. "+l.getName());
				}
			}
			return true;
		}catch(Exception e) {
			logger.warn("Error al mapear json de agencias payjoy. "+e.toString());
		}
		return false;
	}
}
