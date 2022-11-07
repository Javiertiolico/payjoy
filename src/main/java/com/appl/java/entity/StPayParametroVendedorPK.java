package com.appl.java.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ST_PAY_PARAMETRO_VENDEDOR database table.
 * 
 */
@Embeddable
public class StPayParametroVendedorPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="SALESCLERK_ID")
	private String salesclerkId;

	@Column(name="COD_METADATA", insertable=false, updatable=false)
	private long codMetadata;

	public StPayParametroVendedorPK() {
	}
	public String getSalesclerkId() {
		return this.salesclerkId;
	}
	public void setSalesclerkId(String salesclerkId) {
		this.salesclerkId = salesclerkId;
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
		if (!(other instanceof StPayParametroVendedorPK)) {
			return false;
		}
		StPayParametroVendedorPK castOther = (StPayParametroVendedorPK)other;
		return 
			this.salesclerkId.equals(castOther.salesclerkId)
			&& (this.codMetadata == castOther.codMetadata);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.salesclerkId.hashCode();
		hash = hash * prime + ((int) (this.codMetadata ^ (this.codMetadata >>> 32)));
		
		return hash;
	}
	@Override
	public String toString() {
		return "StPayParametroVendedorPK [salesclerkId=" + salesclerkId + ", codMetadata=" + codMetadata + "]";
	}
	
}