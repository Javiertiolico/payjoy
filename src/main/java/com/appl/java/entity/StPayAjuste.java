package com.appl.java.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;


/**
 * The persistent class for the ST_PAY_AJUSTE database table.
 * 
 */
@Entity
@Table(name="ST_PAY_AJUSTE")
//@NamedQuery(name="StPayAjuste.findAll", query="SELECT s FROM StPayAjuste s")
public class StPayAjuste implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private StPayAjustePK id;

	@Column(name="ADJUSTMENT_NOTES")
	private String adjustmentNotes;

	@Column(name="ADJUSTMENT_TYPE")
	private String adjustmentType;

	private BigDecimal amount;

	@Column(name = "FECHA")
	private Timestamp fecha;
	
	@Column(name="ANULADO")
	private String anulado;

	@Column(name="MERCHANT_ID")
	private String merchantId;

	@Column(name="MERCHANT_NAME")
	private String merchantName;

	public StPayAjuste() {
	}

	public StPayAjustePK getId() {
		return this.id;
	}

	public void setId(StPayAjustePK id) {
		this.id = id;
	}

	public String getAdjustmentNotes() {
		return this.adjustmentNotes;
	}

	public void setAdjustmentNotes(String adjustmentNotes) {
		this.adjustmentNotes = adjustmentNotes;
	}

	public String getAdjustmentType() {
		return this.adjustmentType;
	}

	public void setAdjustmentType(String adjustmentType) {
		this.adjustmentType = adjustmentType;
	}

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Timestamp getFecha() {
		return this.fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public String getMerchantId() {
		return this.merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getMerchantName() {
		return this.merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getAnulado() {
		return anulado;
	}

	public void setAnulado(String anulado) {
		this.anulado = anulado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(adjustmentNotes, adjustmentType, amount, anulado, fecha, id, merchantId, merchantName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof StPayAjuste))
			return false;
		StPayAjuste other = (StPayAjuste) obj;
		return Objects.equals(adjustmentNotes, other.adjustmentNotes)
				&& Objects.equals(adjustmentType, other.adjustmentType) && Objects.equals(amount, other.amount)
				&& Objects.equals(anulado, other.anulado) && Objects.equals(fecha, other.fecha)
				&& Objects.equals(id, other.id) && Objects.equals(merchantId, other.merchantId)
				&& Objects.equals(merchantName, other.merchantName);
	}

}