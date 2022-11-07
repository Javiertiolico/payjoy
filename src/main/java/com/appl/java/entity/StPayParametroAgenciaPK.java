package com.appl.java.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ST_PAY_PARAMETRO_AGENCIA database table.
 * 
 */
@Embeddable
public class StPayParametroAgenciaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="MERCHANT_ID")
	private String merchantId;

	@Column(name="COD_METADATA", insertable=false, updatable=false)
	private long codMetadata;

	public StPayParametroAgenciaPK() {
	}
	public String getMerchantId() {
		return this.merchantId;
	}
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}
	public long getCodMetadata() {
		return this.codMetadata;
	}
	public void setCodMetadata(long codMetadata) {
		this.codMetadata = codMetadata;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof StPayParametroAgenciaPK)) {
			return false;
		}
		StPayParametroAgenciaPK castOther = (StPayParametroAgenciaPK)other;
		return 
			this.merchantId.equals(castOther.merchantId)
			&& (this.codMetadata == castOther.codMetadata);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.merchantId.hashCode();
		hash = hash * prime + ((int) (this.codMetadata ^ (this.codMetadata >>> 32)));
		
		return hash;
	}
	@Override
	public String toString() {
		return "StPayParametroAgenciaPK [merchantId=" + merchantId + ", codMetadata=" + codMetadata + "]";
	}
	
}