
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
    "id",
    "purchaseAmount",
    "financeAmount",
    "downPayment",
    "pricePreTax",
    "monthlyCost",
    "weeklyCost",
    "months"
})
@Generated("jsonschema2pojo")
public class FinanceOrder {

    @JsonProperty("id")
    private String id;
    @JsonProperty("purchaseAmount")
    private double purchaseAmount;
    @JsonProperty("financeAmount")
    private double financeAmount;
    @JsonProperty("downPayment")
    private double downPayment;
    @JsonProperty("pricePreTax")
    private double pricePreTax;
    @JsonProperty("monthlyCost")
    private double monthlyCost;
    @JsonProperty("weeklyCost")
    private double weeklyCost;
    @JsonProperty("months")
    private int months;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("purchaseAmount")
    public double getPurchaseAmount() {
        return purchaseAmount;
    }

    @JsonProperty("purchaseAmount")
    public void setPurchaseAmount(double purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    @JsonProperty("financeAmount")
    public double getFinanceAmount() {
        return financeAmount;
    }

    @JsonProperty("financeAmount")
    public void setFinanceAmount(double financeAmount) {
        this.financeAmount = financeAmount;
    }

    @JsonProperty("downPayment")
    public double getDownPayment() {
        return downPayment;
    }

    @JsonProperty("downPayment")
    public void setDownPayment(double downPayment) {
        this.downPayment = downPayment;
    }

    @JsonProperty("pricePreTax")
    public double getPricePreTax() {
        return pricePreTax;
    }

    @JsonProperty("pricePreTax")
    public void setPricePreTax(double pricePreTax) {
        this.pricePreTax = pricePreTax;
    }

    @JsonProperty("monthlyCost")
    public double getMonthlyCost() {
        return monthlyCost;
    }

    @JsonProperty("monthlyCost")
    public void setMonthlyCost(double monthlyCost) {
        this.monthlyCost = monthlyCost;
    }

    @JsonProperty("weeklyCost")
    public double getWeeklyCost() {
        return weeklyCost;
    }

    @JsonProperty("weeklyCost")
    public void setWeeklyCost(double weeklyCost) {
        this.weeklyCost = weeklyCost;
    }

    @JsonProperty("months")
    public int getMonths() {
        return months;
    }

    @JsonProperty("months")
    public void setMonths(int months) {
        this.months = months;
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
