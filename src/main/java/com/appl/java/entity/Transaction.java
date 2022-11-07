
package com.appl.java.entity;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "type",
    "time",
    "amount",
    "currency",
    "financeOrder",
    "merchant",
    "salesClerk",
    "customer",
    "device",
    "payment",
    "adjustment"
})
@Generated("jsonschema2pojo")
public class Transaction {

    @JsonProperty("type")
    private String type;
    @JsonProperty("time")
    private long time;
    @JsonProperty("amount")
    private double amount;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("financeOrder")
    private FinanceOrder financeOrder;
    @JsonProperty("merchant")
    private Merchant merchant;
    @JsonProperty("salesClerk")
    private SalesClerk salesClerk;
    @JsonProperty("customer")
    private Customer customer;
    @JsonProperty("device")
    private Device device;
    @JsonProperty("payment")
    private Payment payment;
    @JsonProperty("adjustment")
    private Adjustment adjustment;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("time")
    public long getTime() {
        return time;
    }

    @JsonProperty("time")
    public void setTime(long time) {
        this.time = time;
    }

    @JsonProperty("amount")
    public double getAmount() {
        return amount;
    }

    @JsonProperty("amount")
    public void setAmount(double amount) {
        this.amount = amount;
    }

    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @JsonProperty("financeOrder")
    public FinanceOrder getFinanceOrder() {
        return financeOrder;
    }

    @JsonProperty("financeOrder")
    public void setFinanceOrder(FinanceOrder financeOrder) {
        this.financeOrder = financeOrder;
    }

    @JsonProperty("merchant")
    public Merchant getMerchant() {
        return merchant;
    }

    @JsonProperty("merchant")
    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    @JsonProperty("salesClerk")
    public SalesClerk getSalesClerk() {
        return salesClerk;
    }

    @JsonProperty("salesClerk")
    public void setSalesClerk(SalesClerk salesClerk) {
        this.salesClerk = salesClerk;
    }

    @JsonProperty("customer")
    public Customer getCustomer() {
        return customer;
    }

    @JsonProperty("customer")
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @JsonProperty("device")
    public Device getDevice() {
        return device;
    }

    @JsonProperty("device")
    public void setDevice(Device device) {
        this.device = device;
    }

    @JsonProperty("payment")
    public Payment getPayment() {
        return payment;
    }

    @JsonProperty("payment")
    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @JsonProperty("adjustment")
    public Adjustment getAdjustment() {
        return adjustment;
    }

    @JsonProperty("adjustment")
    public void setAdjustment(Adjustment adjustment) {
        this.adjustment = adjustment;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
