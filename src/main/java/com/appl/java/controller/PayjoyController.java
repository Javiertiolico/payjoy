package com.appl.java.controller;

import java.math.BigDecimal;

import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.appl.java.entity.ResultadoPayJoy;
import com.appl.java.entity.StPayAjuste;
import com.appl.java.entity.StPayAjustePK;
import com.appl.java.entity.StPayCash;
import com.appl.java.entity.StPayCashPK;
import com.appl.java.entity.StPayFinance;
import com.appl.java.entity.StPayFinancePK;
import com.appl.java.entity.StPayMetadata;
import com.appl.java.entity.Transaction;
import com.appl.java.service.IAjusteService;
import com.appl.java.service.ICashService;
import com.appl.java.service.IFinanceService;
import com.appl.java.service.IMetadataService;
import com.appl.java.util.Util;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.jboss.logging.Logger;



@RestController
//@RequestMapping("/api")
public class PayjoyController {
	@Autowired
	private IMetadataService metadataService;
	@Autowired
	private IFinanceService service;
	@Autowired
	private ICashService cashService;
	@Autowired
	private IAjusteService ajusteService;

	final Logger logger = Logger.getLogger(getClass());
	/**
	 * Prepara la url para consultar transacciones en api
	 * @return String mensaje de ejecucion de proceso
	 */
	@GetMapping (value= {"/transacciones", "/transacciones/"})
	public String getConsultaPay() {
		String salida="";
		try {
			String _url = "";
			StPayMetadata _config = metadataService.findOne(1);
			if(_config!=null) {
				salida = "prepara config. ";
				Util _util = new Util();
				String _hasta = _util.truncateStr(_util.getCurrentDate(), 10 ); //fecha actual de 10 digitos
				String _desde = _util.truncateStr(_util.getPastDate("mes", 1), 10); //fecha mes anterior de 10 digitos
				if(_config.getParamHasta()!=null && !_config.getParamHasta().isEmpty()) {
					_desde = _config.getParamHasta();
				}
				_url = _config.getEndpoint();
				//_url = "https://partner.payjoy.com/v1/list-transactions.php?key={{LLAVE}}&starttime={{DESDE}}&endtime={{HASTA}}";
				_url = _url.replaceFirst("\\{\\{LLAVE\\}\\}", _config.getApikey());
				_url = _url.replaceFirst("\\{\\{DESDE\\}\\}", _desde);
				_url = _url.replaceFirst("\\{\\{HASTA\\}\\}", _hasta);
			}
			logger.info("url: "+_url);
			salida += _url;
			getConsulta(_url, true);
			logger.info("fin de proceso. transacciones payjoy");
			salida += "fin de proceso.";
		}catch(Exception e) {
			salida += "Error consultar parametros de st_metadata "+e.toString();
			logger.warn("Error consultar parametros de st_metadata "+e.toString());
		}
		return "Consulta API de PayJoy "+salida;
	}

	/**
	 * Prepara la url con rango de fechas
	 * @param desde fecha inicial yyyy-mm-dd
	 * @param hasta fecha final yyyy-mm-dd
	 * @param local nombre de la agencia (opcional)
	 * @return String
	 */
	@GetMapping (value= {"/transacciones/{desde}/{hasta}", "/transacciones/{desde}/{hasta}/", "/transacciones/{desde}/{hasta}/{local:.+}"})
	public String getConsultaWithParams(@PathVariable String desde, @PathVariable String hasta, @PathVariable(required = false) String local) {
		try {
			//String payJoyUrl = "https://partner.payjoy.com/v1/list-transactions.php?key=FKwAIfB2kbGvpZ7I6qcLPQBZ75TXoP_i&starttime="+desde+"&endtime="+hasta;
			String _url = "";
			Util _util = new Util();
			String _desde = _util.truncateStr(_util.strDateToLong(desde), 10); // unixtime 10 digitos
			String _hasta = _util.truncateStr(_util.strDateToLong(hasta), 10); // unixtime 10 digitos
			boolean _validDesde = Pattern.compile("^\\d{10,15}$").matcher(_desde).matches();
			boolean _validHasta = Pattern.compile("^\\d{10,15}$").matcher(_hasta).matches();
			StPayMetadata _config = metadataService.findOne(1);
			if(_config!=null && _validDesde && _validHasta) {
				_url = _config.getEndpoint();
				_url = _url.replaceFirst("\\{\\{LLAVE\\}\\}", _config.getApikey());
				_url = _url.replaceFirst("\\{\\{DESDE\\}\\}", _desde);
				_url = _url.replaceFirst("\\{\\{HASTA\\}\\}", _hasta);
			}
			if(local!=null) {
				_url += "&filter=merchant.name:"+local.trim().replaceAll("\\s", "+");
				System.out.println("local: "+local.trim().replaceAll("\\s", "+"));
			}
			logger.info("url con params: "+_url);
			getConsulta(_url, false);
			logger.info("fin de proceso. transacciones de payjoy con params");
		}catch(Exception e) {
			logger.warn("Error al validar parametros y/o consultar params de st_metadata. "+e.toString());
		}
		return "Consulta API de PayJoy con parametros desde "+desde+" a "+hasta;
	}
	/**
	 * Pruebas con simulador de json y estructura igual a tranasacciones. Solo para desarrollo
	 * @return String
	 */
	@GetMapping("/demo")
	public String getConsultaPrueba() {
		String _url = "https://demo6124880.mockable.io/listar";
		try {
			logger.info("url pruebas: "+_url);
			getConsulta(_url, false); // no ejecuta postproceso
		}catch(Exception e) {
			logger.warn("Error al consultar api de pruebas. "+e.toString());
		}
		return "Consulta API con data de prueba desde "+_url;
	}
	/**
	 * Consulta la api e payjoy
	 * @param url direccion de transacciones de payjoy
	 * @param opt true para actualiar fechas de parametros
	 * @return string
	 */
	public String getConsulta(String url, boolean opt) {
		try {
			logger.info("incio de consulta transacciones");
			CloseableHttpClient httpClient = HttpClients.custom().setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE).build();
			HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
			requestFactory.setHttpClient(httpClient);
			ResponseEntity<String> response = new RestTemplate(requestFactory).exchange(url , HttpMethod.GET, null, String.class);
			ObjectMapper mapper = new ObjectMapper();
			ResultadoPayJoy _pj = mapper.readValue(response.getBody(), ResultadoPayJoy.class);
			if(_pj != null) {
				boolean _estado = mapeaObjetos(_pj);
				if(_estado && opt) {
					postProceso();
				}
			}
			logger.info("fin de consulta transacciones");
		}catch(Exception e) {
			logger.warn("Error al consultar api. "+url+". "+e.toString());
		}

		return "Consulta api externa";
	}
	/**
	 * Actualiza las fechas desde y hasta en st_pay_metadata
	 */
	private void postProceso() {
		try {
			Util _util = new Util();
			StPayMetadata _obj = new StPayMetadata();
			_obj.setCodMetadata(1);
			_obj.setParamHasta(_util.truncateStr(_util.getPastDate("dia", 1), 10)); //unix time 10 digitos
			metadataService.update(_obj);
		}catch(Exception e) {
			logger.warn("Error al actualizar fecha hasta en st_metadata. "+e.toString());
		}
	}
	/**
	 * Mapea la respuesta de PayJoy con el esquema de las tablas
	 * @param input respuesta de payjoy
	 */
	private boolean mapeaObjetos(ResultadoPayJoy input) {
		try {
			if(!input.isValid()) {
				logger.info("No hay transacciones desde PayJoy para procesar");
				return false;
			}
			List<Transaction> _transacciones = input.getTransactions();
			_transacciones.sort(Comparator.comparing(Transaction::getType));
			logger.info("cuantas trx "+ _transacciones.size());
			Util util = new Util(); // conversiones
			int len20 = 20, len100=100, len30=30;
			/*Separe las finance de cash y commision ya que por orden es lo primero que debe ingresar*/

			for(Transaction trx : _transacciones) {
				if (trx.getType().equalsIgnoreCase("finance")) {
					StPayFinancePK pk = new StPayFinancePK();
					pk.setFinanceorderId(util.truncateStr(trx.getFinanceOrder().getId(), len20));
					pk.setCodMetadata(1); // default para payjoy
					StPayFinance finance = new StPayFinance();
					finance.setId(pk);
					finance.setPurchaseamount(util.doubleToBigDecimal(trx.getFinanceOrder().getPurchaseAmount()));
					finance.setFinanceamount(util.doubleToBigDecimal(trx.getFinanceOrder().getFinanceAmount()));
					finance.setDownpayment(util.doubleToBigDecimal(trx.getFinanceOrder().getDownPayment()));
					finance.setPricepretax(util.doubleToBigDecimal(trx.getFinanceOrder().getPricePreTax()));
					finance.setMonthlycost(util.doubleToBigDecimal(trx.getFinanceOrder().getMonthlyCost()));
					finance.setWeeklycost(util.doubleToBigDecimal(trx.getFinanceOrder().getWeeklyCost()));
					finance.setMeses(util.validateInt(trx.getFinanceOrder().getMonths()));
					finance.setMerchantId(util.truncateStr(trx.getMerchant().getId(), len20));
					finance.setMerchantName(util.truncateStr(trx.getMerchant().getName(), len100));
					finance.setSalesclerkId(util.truncateStr(trx.getSalesClerk().getId(), len20));
					finance.setSalesclerkName(util.truncateStr(trx.getSalesClerk().getName(), len100));
					finance.setCustomerId(util.truncateStr(trx.getCustomer().getId(), len20));
					finance.setCustomerName(util.truncateStr(trx.getCustomer().getName(), len100));
					finance.setCustomerPhonenumber(util.truncateStr(trx.getCustomer().getPhoneNumber(), len20));
					finance.setDevicePhonenumber(util.truncateStr(trx.getDevice().getPhoneNumber(), len20));
					finance.setDeviceSimnumber(util.truncateStr(trx.getDevice().getSimNumber(), len30));
					finance.setDeviceImei(util.truncateStr(trx.getDevice().getImei(), len30));
					finance.setFamilyId(util.truncateStr(trx.getDevice().getFamily().getId(), len20));
					finance.setFamilyName(util.truncateStr(trx.getDevice().getFamily().getName(), len100));
					finance.setModelId(util.truncateStr(trx.getDevice().getModel().getId(), len20));
					finance.setModelMakemodel(util.truncateStr(trx.getDevice().getModel().getMakeModel(), len100));
					finance.setModelName(util.truncateStr(trx.getDevice().getModel().getName(), len100));
					finance.setFecha(util.timeFromLong(trx.getTime()));
					finance.setAnulado("N"); // default en registro nuevo
					//guarda
					StPayFinance _found = service.findOne(pk);
					if (_found == null) {
						logger.info("finance es nueva. " + pk);
						service.save(finance);
					} else {
						logger.info("finance ya existe en db. " + pk);
					}
					System.out.println("estructura finanzas procesada");
				}else if(trx.getType().equalsIgnoreCase("cash")) {
					StPayCashPK pk = new StPayCashPK();
					pk.setFinanceorderId(util.truncateStr(trx.getFinanceOrder().getId(), len20));
					pk.setPaymentId(util.truncateStr(trx.getPayment().getId(), len20));
					pk.setCodMetadata(1); // default para payjoy
					StPayCash cash = new StPayCash();
					cash.setId(pk);
					cash.setAmount(util.doubleToBigDecimal(trx.getPayment().getAmount()));
					cash.setMerchantId(util.truncateStr(trx.getMerchant().getId(), len20));
					cash.setMerchantName(util.truncateStr(trx.getMerchant().getName(), len100));
					cash.setSalesclerkId(util.truncateStr(trx.getSalesClerk().getId(), len20));
					cash.setSalesclerkName(util.truncateStr(trx.getSalesClerk().getName(), len100));
					cash.setCustomerId(util.truncateStr(trx.getCustomer().getId(), len20));
					cash.setCustomerName(util.truncateStr(trx.getCustomer().getName(), len100));
					cash.setCustomerPhonenumber(util.truncateStr(trx.getCustomer().getPhoneNumber(), len20));
					cash.setFecha(util.timeFromLong(trx.getTime()));
					cash.setComission(BigDecimal.valueOf(0)); //default
					cash.setAnulado("N"); // default en registro nuevo
					StPayCash _found = cashService.findOne(pk);
					if(_found==null) {
						//StPayFinance _test = service.findOne(_found.);
						logger.info("cash es nueva. "+pk);
						cashService.save(cash);
					}else {
						logger.info("cash ya existe en db. "+pk);
					}
					System.out.println("estructura cash procesada");
				}else if(trx.getType().equalsIgnoreCase("commission")) {
					double _pagoEntrada = 0.0;
					if(trx.getPayment()==null && trx.getFinanceOrder()!=null) {
						if(trx.getFinanceOrder().getDownPayment()>0) {
							_pagoEntrada = trx.getFinanceOrder().getDownPayment();
						}
					}
					StPayCashPK pk = new StPayCashPK();
					pk.setFinanceorderId(util.truncateStr(trx.getFinanceOrder().getId(), len20));
					pk.setPaymentId(util.truncateStr(trx.getPayment()==null?"0":trx.getPayment().getId(), len20));
					pk.setCodMetadata(1); // default para payjoy
					StPayCash com = new StPayCash();
					com.setId(pk);
					com.setAmount(util.doubleToBigDecimal(trx.getPayment()==null?_pagoEntrada:trx.getPayment().getAmount()));
					com.setMerchantId(util.truncateStr(trx.getMerchant().getId(), len20));
					com.setMerchantName(util.truncateStr(trx.getMerchant().getName(), len100));
					com.setSalesclerkId(util.truncateStr(trx.getSalesClerk().getId(), len20));
					com.setSalesclerkName(util.truncateStr(trx.getSalesClerk().getName(), len100));
					com.setCustomerId(util.truncateStr(trx.getCustomer().getId(), len20));
					com.setCustomerName(util.truncateStr(trx.getCustomer().getName(), len100));
					com.setCustomerPhonenumber(util.truncateStr(trx.getCustomer().getPhoneNumber(), len20));
					com.setFecha(util.timeFromLong(trx.getTime()));
					com.setComission(util.doubleToBigDecimal(trx.getAmount()));
					com.setAnulado("N"); // default en registro nuevo
					StPayCash _found = cashService.findOne(pk);
					if(_found!=null) {
						logger.info("cash ya existe en db");
						if(_found.getComission().compareTo(com.getComission())!=0) {
							logger.info("Comisión va a actualizarse en cash. "+pk);
							cashService.update(com);
						}else {
							logger.info("comisión ya estuvo actualizada. cash+comision ya existe. "+pk);
						}
					}else {
						logger.info("no cash. cash+comisión es nueva. "+pk);
						cashService.save(com);
					}
					System.out.println("estructura comission procesada");
				}else if(trx.getType().equalsIgnoreCase("adjustment")) {
					int len200 = 200;
					StPayAjustePK pk = new StPayAjustePK();
					pk.setAdjustmentId(util.truncateStr(trx.getAdjustment().getId(), len20));
					pk.setCodMetadata(1); // default para payjoy
					StPayAjuste adj = new StPayAjuste();
					adj.setId(pk);
					adj.setAdjustmentType(util.truncateStr(trx.getAdjustment().getType(), len20));
					adj.setAdjustmentNotes(util.truncateStr(trx.getAdjustment().getNotes(), len200));
					adj.setMerchantId(util.truncateStr(trx.getMerchant().getId(), len20));
					adj.setMerchantName(util.truncateStr(trx.getMerchant().getName(), len100));
					adj.setAmount(util.doubleToBigDecimal(trx.getAmount()));
					adj.setFecha(util.timeFromLong(trx.getTime()));
					adj.setAnulado("N"); // default en registro nuevo
					StPayAjuste _found = ajusteService.findOne(pk);
					if(_found==null) {
						logger.info("adjustment es nueva. "+pk);
						ajusteService.save(adj);
					}else {
						logger.info("adjustment ya existe en db. "+pk);
					}
					postAjuste(adj);
					System.out.println("estructura adjustment procesada");
				}else {
					logger.info("Procesando estructura desconocida "+trx.getType());
				}
			}
			return true;
		}catch(Exception e) {
			logger.warn("Error al mapear json de transacciones de payjoy. "+e.toString());
		}
		return false;
	}
	/**
	 * Analiza la adjustment para reversar finance y commission
	 * @param adjustment object
	 */
	private void postAjuste(StPayAjuste adjustment) {
		try {
			String _target = "financeOrder";
			if(adjustment.getAdjustmentNotes().contains(_target)) { // busca finance order en notes de adjustment
				String _financeOrderId = "0"; // busca id (financeOrder)\s+(\d{4,20})
				Matcher _matcher = Pattern.compile(_target+"\\s+\\d{4,20}").matcher(adjustment.getAdjustmentNotes());
				if(_matcher.find()) {
					String _valor = _matcher.group(); //extrae solo id
					_valor = _valor.replaceAll(_target, "").trim();
					_financeOrderId = _valor.length()>0 ? _valor : "0";
				}
				if(!_financeOrderId.equalsIgnoreCase("0") && adjustment.getAdjustmentType().equalsIgnoreCase("finance") ) {
					StPayFinancePK pk = new StPayFinancePK(_financeOrderId,1L); // 1 default para payjoy
					StPayFinance _found= service.findOne(pk);
					if(_found!=null) {
						if(_found.getAnulado().equalsIgnoreCase("N") && _found.getFinanceamount().compareTo(adjustment.getAmount().abs())==0) { // revisa costo financiamiento
							_found.setAnulado("S"); //finance anulado
							service.updateAnulado(_found);
						}else {
							logger.info(pk+" anulada= "+_found.getAnulado());
						}
					}else {
						logger.info("Finance no encontrada. "+pk);
					}
				}else if(!_financeOrderId.equalsIgnoreCase("0") && adjustment.getAdjustmentType().equalsIgnoreCase("commission")) {
					StPayCashPK pk = new StPayCashPK("0",_financeOrderId,1L); //paymentId es 0 xq no viene en adjustment
					StPayCash _found = cashService.findOne(pk);
					if(_found!=null) {
						if(_found.getAnulado().equalsIgnoreCase("N") && _found.getComission().compareTo(adjustment.getAmount().abs())==0) { // revisa comision
							_found.setAnulado("S"); //comision anulada.
							cashService.updateAnulado(_found);
						}else {
							logger.info(pk+" anulada= "+_found.getAnulado());
						}
					}else {
						logger.info("Comision no encontrada. "+pk);
					}
				}else {
					logger.info("valor de financeOrderId: "+_financeOrderId+" de tipo "+adjustment.getAdjustmentType());
				}
			}
			System.out.println("Termina post ajuste");
		}catch(Exception e) {
			logger.warn("Error al analizar adjustment (post proceso). "+e.toString());
		}
	}
}
