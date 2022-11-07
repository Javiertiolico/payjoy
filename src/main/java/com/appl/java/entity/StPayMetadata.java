package com.appl.java.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Blob;
import java.util.Objects;


/**
 * The persistent class for the ST_PAY_METADATA database table.
 * 
 */
@Entity
@Table(name="ST_PAY_METADATA")
//@NamedQuery(name="StPayMetadata.findAll", query="SELECT s FROM StPayMetadata s")
public class StPayMetadata implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="COD_METADATA")
	private long codMetadata;

	private String apikey;

	@Column(name="COD_FORMA_PAGO")
	private String codFormaPago;

	@Column(name="COD_POLITICA")
	private BigDecimal codPolitica;

	private String endpoint;
	
	//@Column(name="ADICIONADO_POR")
	//private String adicionadoPor;

	//@Column(name="FECHA_ADICION")
	//private Object fechaAdicion;

	//@Column(name="FECHA_MODIFICACION")
	//private Object fechaModificacion;

	//@Column(name="MODIFICADO_POR")
	//private String modificadoPor;

	@Column(name="NOMBRE_EMPRESA")
	private String nombreEmpresa;

	@Column(name="NUM_PAGOS")
	private BigDecimal numPagos;

	@Column(name="PARAM_ADICIONAL")
	private String paramAdicional;

	@Column(name="PARAM_DESDE")
	private String paramDesde;

	@Column(name="PARAM_EXTRA")
	private String paramExtra;

	@Column(name="PARAM_HASTA")
	private String paramHasta;

	@Column(name="PARAM_LOCAL")
	private String paramLocal;

	@Column(name="RUC_EMPRESA")
	private String rucEmpresa;

	public StPayMetadata() {
	}

	public long getCodMetadata() {
		return this.codMetadata;
	}

	public void setCodMetadata(long codMetadata) {
		this.codMetadata = codMetadata;
	}

	/*public String getAdicionadoPor() {
		return this.adicionadoPor;
	}

	public void setAdicionadoPor(String adicionadoPor) {
		this.adicionadoPor = adicionadoPor;
	}*/

	public String getApikey() {
		return this.apikey;
	}

	public void setApikey(String apikey) {
		this.apikey = apikey;
	}

	public String getCodFormaPago() {
		return this.codFormaPago;
	}

	public void setCodFormaPago(String codFormaPago) {
		this.codFormaPago = codFormaPago;
	}

	public BigDecimal getCodPolitica() {
		return this.codPolitica;
	}

	public void setCodPolitica(BigDecimal codPolitica) {
		this.codPolitica = codPolitica;
	}

	public String getEndpoint() {
		return this.endpoint;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

	/*public Object getFechaAdicion() {
		return this.fechaAdicion;
	}

	public void setFechaAdicion(Object fechaAdicion) {
		this.fechaAdicion = fechaAdicion;
	}*/

	/*public Object getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Object fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}*/

	/*public String getModificadoPor() {
		return this.modificadoPor;
	}

	public void setModificadoPor(String modificadoPor) {
		this.modificadoPor = modificadoPor;
	}*/

	public String getNombreEmpresa() {
		return this.nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public BigDecimal getNumPagos() {
		return this.numPagos;
	}

	public void setNumPagos(BigDecimal numPagos) {
		this.numPagos = numPagos;
	}

	public String getParamAdicional() {
		return this.paramAdicional;
	}

	public void setParamAdicional(String paramAdicional) {
		this.paramAdicional = paramAdicional;
	}

	public String getParamDesde() {
		return this.paramDesde;
	}

	public void setParamDesde(String paramDesde) {
		this.paramDesde = paramDesde;
	}

	public String getParamExtra() {
		return this.paramExtra;
	}

	public void setParamExtra(String paramExtra) {
		this.paramExtra = paramExtra;
	}

	public String getParamHasta() {
		return this.paramHasta;
	}

	public void setParamHasta(String paramHasta) {
		this.paramHasta = paramHasta;
	}

	public String getParamLocal() {
		return this.paramLocal;
	}

	public void setParamLocal(String paramLocal) {
		this.paramLocal = paramLocal;
	}

	public String getRucEmpresa() {
		return this.rucEmpresa;
	}

	public void setRucEmpresa(String rucEmpresa) {
		this.rucEmpresa = rucEmpresa;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apikey, codFormaPago, codMetadata, codPolitica, endpoint, nombreEmpresa, numPagos,
				paramAdicional, paramDesde, paramExtra, paramHasta, paramLocal, rucEmpresa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof StPayMetadata))
			return false;
		StPayMetadata other = (StPayMetadata) obj;
		return Objects.equals(apikey, other.apikey) && Objects.equals(codFormaPago, other.codFormaPago)
				&& codMetadata == other.codMetadata && Objects.equals(codPolitica, other.codPolitica)
				&& Objects.equals(endpoint, other.endpoint) && Objects.equals(nombreEmpresa, other.nombreEmpresa)
				&& Objects.equals(numPagos, other.numPagos) && Objects.equals(paramAdicional, other.paramAdicional)
				&& Objects.equals(paramDesde, other.paramDesde) && Objects.equals(paramExtra, other.paramExtra)
				&& Objects.equals(paramHasta, other.paramHasta) && Objects.equals(paramLocal, other.paramLocal)
				&& Objects.equals(rucEmpresa, other.rucEmpresa);
	}

	@Override
	public String toString() {
		return "StPayMetadata [codMetadata=" + codMetadata + ", apikey=" + apikey + ", codFormaPago=" + codFormaPago
				+ ", codPolitica=" + codPolitica + ", endpoint=" + endpoint + ", nombreEmpresa=" + nombreEmpresa
				+ ", numPagos=" + numPagos + ", paramAdicional=" + paramAdicional + ", paramDesde=" + paramDesde
				+ ", paramExtra=" + paramExtra + ", paramHasta=" + paramHasta + ", paramLocal=" + paramLocal
				+ ", rucEmpresa=" + rucEmpresa + "]";
	}
	

}