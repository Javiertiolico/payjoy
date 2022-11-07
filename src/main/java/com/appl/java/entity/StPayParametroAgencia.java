package com.appl.java.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;


/**
 * The persistent class for the ST_PAY_PARAMETRO_AGENCIA database table.
 * 
 */
@Entity
@Table(name="ST_PAY_PARAMETRO_AGENCIA")
//@NamedQuery(name="StPayParametroAgencia.findAll", query="SELECT s FROM StPayParametroAgencia s")
public class StPayParametroAgencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private StPayParametroAgenciaPK id;

	@Column(name="COD_AGENCIA")
	private long codAgencia;

	private int empresa;

	@Column(name="MERCHANT_NAME")
	private String merchantName;

	public StPayParametroAgencia() {
	}

	public StPayParametroAgenciaPK getId() {
		return this.id;
	}

	public void setId(StPayParametroAgenciaPK id) {
		this.id = id;
	}

	public long getCodAgencia() {
		return this.codAgencia;
	}

	public void setCodAgencia(long codAgencia) {
		this.codAgencia = codAgencia;
	}

	public int getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(int empresa) {
		this.empresa = empresa;
	}

	public String getMerchantName() {
		return this.merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codAgencia, empresa, id, merchantName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof StPayParametroAgencia))
			return false;
		StPayParametroAgencia other = (StPayParametroAgencia) obj;
		return codAgencia == other.codAgencia && empresa == other.empresa && Objects.equals(id, other.id)
				&& Objects.equals(merchantName, other.merchantName);
	}
	

}