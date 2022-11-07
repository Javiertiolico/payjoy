package com.appl.java.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

/**
 * The primary key class for the ST_PAY_CASH database table.
 * 
 */
@Embeddable
public class StPayCashPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="PAYMENT_ID")
	private String paymentId;

	@Column(name="FINANCEORDER_ID", insertable=false, updatable=false)
	private String financeorderId;
	
	@Column(name="COD_METADATA")
	private long codMetadata;

	public StPayCashPK() {
	}
	
	public StPayCashPK(String paymentId, String financeorderId, long codMetadata) {
		super();
		this.paymentId = paymentId;
		this.financeorderId = financeorderId;
		this.codMetadata = codMetadata;
	}

	public long getCodMetadata() {
		return codMetadata;
	}

	public void setCodMetadata(long codMetadata) {
		this.codMetadata = codMetadata;
	}
	public String getPaymentId() {
		return this.paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	public String getFinanceorderId() {
		return this.financeorderId;
	}
	public void setFinanceorderId(String financeorderId) {
		this.financeorderId = financeorderId;
	}
	@Override
	public int hashCode() {
		return Objects.hash(codMetadata, financeorderId, paymentId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof StPayCashPK))
			return false;
		StPayCashPK other = (StPayCashPK) obj;
		return codMetadata == other.codMetadata && Objects.equals(financeorderId, other.financeorderId)
				&& Objects.equals(paymentId, other.paymentId);
	}
	@Override
	public String toString() {
		return "StPayCashPK [paymentId=" + paymentId + ", financeorderId=" + financeorderId + ", codMetadata="
				+ codMetadata + "]";
	}
	

	
}