package com.appl.java.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;


/**
 * The persistent class for the ST_PAY_CASH database table.
 * 
 */
@Entity
@Table(name="ST_PAY_CASH")
//@NamedQuery(name="StPayCash.findAll", query="SELECT s FROM StPayCash s")
public class StPayCash implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private StPayCashPK id;

	private BigDecimal amount;
	@Column(name = "COMISION")
	private BigDecimal comission;

	@Column(name="CUSTOMER_ID", length = 20)
	private String customerId;

	@Column(name="CUSTOMER_NAME", length = 100)
	private String customerName;

	@Column(name="CUSTOMER_PHONENUMBER", length = 20)
	private String customerPhonenumber;
	
	//@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FECHA")
	private Timestamp fecha; //private Object fecha;

	@Column(name="MERCHANT_ID", length = 20)
	private String merchantId;

	@Column(name="MERCHANT_NAME", length = 100)
	private String merchantName;

	@Column(name="SALESCLERK_ID", length = 20)
	private String salesclerkId;

	@Column(name="SALESCLERK_NAME", length = 100)
	private String salesclerkName;
	
	@Column(name="ANULADO")
	private String anulado;
	
	//bi-directional many-to-one association to StPayFinance
	//@ManyToOne
	//@JoinColumn(name="FINANCEORDER_ID")
	//private StPayFinance stPayFinance;

	public StPayCash() {
	}

	public StPayCashPK getId() {
		return this.id;
	}

	public void setId(StPayCashPK id) {
		this.id = id;
	}

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getComission() {
		return this.comission;
	}

	public void setComission(BigDecimal comission) {
		this.comission = comission;
	}

	public String getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPhonenumber() {
		return this.customerPhonenumber;
	}

	public void setCustomerPhonenumber(String customerPhonenumber) {
		this.customerPhonenumber = customerPhonenumber;
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

	public String getSalesclerkId() {
		return this.salesclerkId;
	}

	public void setSalesclerkId(String salesclerkId) {
		this.salesclerkId = salesclerkId;
	}

	public String getSalesclerkName() {
		return this.salesclerkName;
	}

	public void setSalesclerkName(String salesclerkName) {
		this.salesclerkName = salesclerkName;
	}

	public String getAnulado() {
		return anulado;
	}

	public void setAnulado(String anulado) {
		this.anulado = anulado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, anulado, comission, customerId, customerName, customerPhonenumber, fecha, id,
				merchantId, merchantName, salesclerkId, salesclerkName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof StPayCash))
			return false;
		StPayCash other = (StPayCash) obj;
		return Objects.equals(amount, other.amount) && Objects.equals(anulado, other.anulado)
				&& Objects.equals(comission, other.comission) && Objects.equals(customerId, other.customerId)
				&& Objects.equals(customerName, other.customerName)
				&& Objects.equals(customerPhonenumber, other.customerPhonenumber) && Objects.equals(fecha, other.fecha)
				&& Objects.equals(id, other.id) && Objects.equals(merchantId, other.merchantId)
				&& Objects.equals(merchantName, other.merchantName) && Objects.equals(salesclerkId, other.salesclerkId)
				&& Objects.equals(salesclerkName, other.salesclerkName);
	}

	/*public StPayFinance getStPayFinance() {
		return this.stPayFinance;
	}*/

	/*public void setStPayFinance(StPayFinance stPayFinance) {
		this.stPayFinance = stPayFinance;
	}*/
	
}