package com.appl.java.controller;

import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

//import com.appl.java.entity.ResultadoPayJoy;
//import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@RestController
public class PruebaController {
	@GetMapping("/prueba")
	public String getMensaje() {
		return "Respuesta desde ws";
	}
	@GetMapping("/pruebapj")
	public String getMensajePJ() {
		getConsulta("https://partner.payjoy.com/v1/list-transactions.php?key=FKwAIfB2kbGvpZ7I6qcLPQBZ75TXoP_i&starttime=1630454400&endtime=1633046399", false);
		return "Consulta a payjoy y guarda en archivo";
	}
	// prueba prod
	public String getConsulta(String url, boolean opt) {
		try {
			System.out.println("incio de consulta");
			CloseableHttpClient httpClient = HttpClients.custom().setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE).build();
		    HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		    requestFactory.setHttpClient(httpClient);
		    ResponseEntity<String> response = new RestTemplate(requestFactory).exchange(url , HttpMethod.GET, null, String.class);
			saveToFile(response.getBody());
		    //ObjectMapper mapper = new ObjectMapper();
			//ResultadoPayJoy _pj = mapper.readValue(response.getBody(), ResultadoPayJoy.class); 
			System.out.println("fin de consulta");
		}catch(Exception e) {
			System.out.println("Error al consultar api. "+url+". "+e.toString());
		}
		
		return "Consulta api externa. payjoy manual de septiembre";
	}
	private void saveToFile(String data) {
		File file = new File("/home/jboss/dataPJ.txt");
        //File file = new File("C:\\pcinstallers\\dataPJ.txt"); 
        FileWriter fr = null;
        try {
            fr = new FileWriter(file);
            fr.write(data);
            System.out.println("archivo guardado");
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            //close resources
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
