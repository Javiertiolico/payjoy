package com.appl.java.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * The persistent class for the ST_PAY_FINANCE database table.
 * 
 */
@Entity
@Table(name="ST_PAY_FINANCE")
//@NamedQuery(name="StPayFinance.findAll", query="SELECT s FROM StPayFinance s")
public class StPayFinance implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private StPayFinancePK id;

	@Column(name="CUSTOMER_ID", length = 20)
	private String customerId;

	@Column(name="CUSTOMER_NAME", length = 100)
	private String customerName;

	@Column(name="CUSTOMER_PHONENUMBER", length = 20)
	private String customerPhonenumber;

	@Column(name="DEVICE_IMEI", length = 30)
	private String deviceImei;

	@Column(name="DEVICE_PHONENUMBER", length = 20)
	private String devicePhonenumber;

	@Column(name="DEVICE_SIMNUMBER", length = 30)
	private String deviceSimnumber;

	private BigDecimal downpayment;

	@Column(name="FAMILY_ID", length = 20)
	private String familyId;

	@Column(name="FAMILY_NAME", length = 100)
	private String familyName;
	
	//@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FECHA")
	private Timestamp fecha;

	private BigDecimal financeamount;

	@Column(name="MERCHANT_ID", length = 20)
	private String merchantId;

	@Column(name="MERCHANT_NAME", length = 100)
	private String merchantName;

	private int meses;

	@Column(name="MODEL_ID", length = 20)
	private String modelId;

	@Column(name="MODEL_MAKEMODEL", length = 100)
	private String modelMakemodel;

	@Column(name="MODEL_NAME", length = 100)
	private String modelName;

	private BigDecimal monthlycost;

	private BigDecimal pricepretax;

	private BigDecimal purchaseamount;

	@Column(name="SALESCLERK_ID", length = 20)
	private String salesclerkId;

	@Column(name="SALESCLERK_NAME", length = 100)
	private String salesclerkName;

	private BigDecimal weeklycost;
	
	@Column(name="ANULADO")
	private String anulado;

	//bi-directional many-to-one association to StPayCash
	//@OneToMany(mappedBy="stPayFinance")
	//private List<StPayCash> stPayCashs;

	public StPayFinance() {
	}

	public StPayFinancePK getId() {
		return id;
	}

	public void setId(StPayFinancePK id) {
		this.id = id;
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

	public String getDeviceImei() {
		return this.deviceImei;
	}

	public void setDeviceImei(String deviceImei) {
		this.deviceImei = deviceImei;
	}

	public String getDevicePhonenumber() {
		return this.devicePhonenumber;
	}

	public void setDevicePhonenumber(String devicePhonenumber) {
		this.devicePhonenumber = devicePhonenumber;
	}

	public String getDeviceSimnumber() {
		return this.deviceSimnumber;
	}

	public void setDeviceSimnumber(String deviceSimnumber) {
		this.deviceSimnumber = deviceSimnumber;
	}

	public BigDecimal getDownpayment() {
		return this.downpayment;
	}

	public void setDownpayment(BigDecimal downpayment) {
		this.downpayment = downpayment;
	}

	public String getFamilyId() {
		return this.familyId;
	}

	public void setFamilyId(String familyId) {
		this.familyId = familyId;
	}

	public String getFamilyName() {
		return this.familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public Timestamp getFecha() {
		return this.fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getFinanceamount() {
		return this.financeamount;
	}

	public void setFinanceamount(BigDecimal financeamount) {
		this.financeamount = financeamount;
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

	public int getMeses() {
		return this.meses;
	}

	public void setMeses(int meses) {
		this.meses = meses;
	}

	public String getModelId() {
		return this.modelId;
	}

	public void setModelId(String modelId) {
		this.modelId = modelId;
	}

	public String getModelMakemodel() {
		return this.modelMakemodel;
	}

	public void setModelMakemodel(String modelMakemodel) {
		this.modelMakemodel = modelMakemodel;
	}

	public String getModelName() {
		return this.modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public BigDecimal getMonthlycost() {
		return this.monthlycost;
	}

	public void setMonthlycost(BigDecimal monthlycost) {
		this.monthlycost = monthlycost;
	}

	public BigDecimal getPricepretax() {
		return this.pricepretax;
	}

	public void setPricepretax(BigDecimal pricepretax) {
		this.pricepretax = pricepretax;
	}

	public BigDecimal getPurchaseamount() {
		return this.purchaseamount;
	}

	public void setPurchaseamount(BigDecimal purchaseamount) {
		this.purchaseamount = purchaseamount;
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

	public BigDecimal getWeeklycost() {
		return this.weeklycost;
	}

	public void setWeeklycost(BigDecimal weeklycost) {
		this.weeklycost = weeklycost;
	}

	public String getAnulado() {
		return anulado;
	}

	public void setAnulado(String anulado) {
		this.anulado = anulado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(anulado, customerId, customerName, customerPhonenumber, deviceImei, devicePhonenumber,
				deviceSimnumber, downpayment, familyId, familyName, fecha, financeamount, id, merchantId, merchantName,
				meses, modelId, modelMakemodel, modelName, monthlycost, pricepretax, purchaseamount, salesclerkId,
				salesclerkName, weeklycost);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof StPayFinance))
			return false;
		StPayFinance other = (StPayFinance) obj;
		return Objects.equals(anulado, other.anulado) && Objects.equals(customerId, other.customerId)
				&& Objects.equals(customerName, other.customerName)
				&& Objects.equals(customerPhonenumber, other.customerPhonenumber)
				&& Objects.equals(deviceImei, other.deviceImei)
				&& Objects.equals(devicePhonenumber, other.devicePhonenumber)
				&& Objects.equals(deviceSimnumber, other.deviceSimnumber)
				&& Objects.equals(downpayment, other.downpayment) && Objects.equals(familyId, other.familyId)
				&& Objects.equals(familyName, other.familyName) && Objects.equals(fecha, other.fecha)
				&& Objects.equals(financeamount, other.financeamount) && Objects.equals(id, other.id)
				&& Objects.equals(merchantId, other.merchantId) && Objects.equals(merchantName, other.merchantName)
				&& meses == other.meses && Objects.equals(modelId, other.modelId)
				&& Objects.equals(modelMakemodel, other.modelMakemodel) && Objects.equals(modelName, other.modelName)
				&& Objects.equals(monthlycost, other.monthlycost) && Objects.equals(pricepretax, other.pricepretax)
				&& Objects.equals(purchaseamount, other.purchaseamount)
				&& Objects.equals(salesclerkId, other.salesclerkId)
				&& Objects.equals(salesclerkName, other.salesclerkName) && Objects.equals(weeklycost, other.weeklycost);
	}
	
	
	/*public List<StPayCash> getStPayCashs() {
		return this.stPayCashs;
	}*/

	/*public void setStPayCashs(List<StPayCash> stPayCashs) {
		this.stPayCashs = stPayCashs;
	}*/

	/*public StPayCash addStPayCash(StPayCash stPayCash) {
		getStPayCashs().add(stPayCash);
		stPayCash.setStPayFinance(this);

		return stPayCash;
	}*/

	/*public StPayCash removeStPayCash(StPayCash stPayCash) {
		getStPayCashs().remove(stPayCash);
		stPayCash.setStPayFinance(null);

		return stPayCash;
	}*/

}