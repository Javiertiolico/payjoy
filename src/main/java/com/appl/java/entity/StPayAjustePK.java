package com.appl.java.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ST_PAY_AJUSTE database table.
 * 
 */
@Embeddable
public class StPayAjustePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ADJUSTMENT_ID")
	private String adjustmentId;

	@Column(name="COD_METADATA")
	private long codMetadata;

	public StPayAjustePK() {
	}
	public String getAdjustmentId() {
		return this.adjustmentId;
	}
	public void setAdjustmentId(String adjustmentId) {
		this.adjustmentId = adjustmentId;
	}
	public long getCodMetadata() {
		return this.codMetadata;
	}
	public void setCodMetadata(long codMetadata) {
		this.codMetadata = codMetadata;
	}
	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof StPayAjustePK)) {
			return false;
		}
		StPayAjustePK castOther = (StPayAjustePK)other;
		return 
			this.adjustmentId.equals(castOther.adjustmentId)
			&& (this.codMetadata == castOther.codMetadata);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.adjustmentId.hashCode();
		hash = hash * prime + ((int) (this.codMetadata ^ (this.codMetadata >>> 32)));
		
		return hash;
	}
	@Override
	public String toString() {
		return "StPayAjustePK [adjustmentId=" + adjustmentId + ", codMetadata=" + codMetadata + "]";
	}
	
}