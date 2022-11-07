package com.appl.java.entity;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Producto {
	@JsonProperty("preTaxPrice")
	private double preTaxPrice;
	@JsonProperty("taxPrice")
	private double taxPrice;
	@JsonProperty("fullPrice")
	private double fullPrice;
	@JsonProperty("model")
	private String model;
	@JsonProperty("manufacturer")
	private String manufacturer;
	@JsonProperty("description")
	private String description;
	
	public Producto(double preTaxPrice, double taxPrice, double fullPrice, String model, String manufacturer,
			String description) {
		super();
		this.preTaxPrice = preTaxPrice;
		this.taxPrice = taxPrice;
		this.fullPrice = fullPrice;
		this.model = model;
		this.manufacturer = manufacturer;
		this.description = description;
	}
	public double getPreTaxPrice() {
		return preTaxPrice;
	}
	public void setPreTaxPrice(double preTaxPrice) {
		this.preTaxPrice = preTaxPrice;
	}
	public double getTaxPrice() {
		return taxPrice;
	}
	public void setTaxPrice(double taxPrice) {
		this.taxPrice = taxPrice;
	}
	public double getFullPrice() {
		return fullPrice;
	}
	public void setFullPrice(double fullPrice) {
		this.fullPrice = fullPrice;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public int hashCode() {
		return Objects.hash(description, fullPrice, manufacturer, model, preTaxPrice, taxPrice);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Producto))
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(description, other.description)
				&& Double.doubleToLongBits(fullPrice) == Double.doubleToLongBits(other.fullPrice)
				&& Objects.equals(manufacturer, other.manufacturer) && Objects.equals(model, other.model)
				&& Double.doubleToLongBits(preTaxPrice) == Double.doubleToLongBits(other.preTaxPrice)
				&& Double.doubleToLongBits(taxPrice) == Double.doubleToLongBits(other.taxPrice);
	}
	
}
