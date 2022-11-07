package com.appl.java.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class StPayFinancePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	
	@Column(name="FINANCEORDER_ID", length = 20)
	private String financeorderId;

	@Column(name="COD_METADATA")
	private long codMetadata;

	public StPayFinancePK() {
	}

	public StPayFinancePK(String financeorderId, long codMetadata) {
		super();
		this.financeorderId = financeorderId;
		this.codMetadata = codMetadata;
	}

	public long getCodMetadata() {
		return codMetadata;
	}

	public void setCodMetadata(long codMetadata) {
		this.codMetadata = codMetadata;
	}

	public String getFinanceorderId() {
		return financeorderId;
	}

	public void setFinanceorderId(String financeorderId) {
		this.financeorderId = financeorderId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codMetadata, financeorderId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof StPayFinancePK))
			return false;
		StPayFinancePK other = (StPayFinancePK) obj;
		return codMetadata == other.codMetadata && Objects.equals(financeorderId, other.financeorderId);
	}

	@Override
	public String toString() {
		return "StPayFinancePK [financeorderId=" + financeorderId + ", codMetadata=" + codMetadata + "]";
	}
	
}