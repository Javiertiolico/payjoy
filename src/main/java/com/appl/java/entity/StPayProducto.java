package com.appl.java.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;


/**
 * The persistent class for the ST_PAY_PRODUCTO database table.
 * 
 */
@Entity
@Table(name="ST_PAY_PRODUCTO")
//@NamedQuery(name="StPayProducto.findAll", query="SELECT s FROM StPayProducto s")
public class StPayProducto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private StPayProductoPK id;
	
	@Column(name="COD_PRODUCTO")
	private String codProducto;
	@Column(name="DESCRIPCION")
	private String descripcion;
	@Column(name="FABRICANTE")
	private String fabricante;

	private BigDecimal iva;
	@Column(name="MODELO")
	private String modelo;

	private BigDecimal subtotal;

	private BigDecimal total;
	@Column(name="ESACTIVO")
	private int esActivo;

	public StPayProducto() {
	}
	

	public StPayProductoPK getId() {
		return id;
	}


	public void setId(StPayProductoPK id) {
		this.id = id;
	}


	public int getEsActivo() {
		return esActivo;
	}

	public void setEsActivo(int esActivo) {
		this.esActivo = esActivo;
	}

	public String getCodProducto() {
		return this.codProducto;
	}

	public void setCodProducto(String codProducto) {
		this.codProducto = codProducto;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFabricante() {
		return this.fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public BigDecimal getIva() {
		return this.iva;
	}

	public void setIva(BigDecimal iva) {
		this.iva = iva;
	}

	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public BigDecimal getSubtotal() {
		return this.subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public BigDecimal getTotal() {
		return this.total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	

	@Override
	public int hashCode() {
		return Objects.hash(codProducto, descripcion, esActivo, fabricante, id, iva, modelo, subtotal, total);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof StPayProducto))
			return false;
		StPayProducto other = (StPayProducto) obj;
		return Objects.equals(codProducto, other.codProducto) && Objects.equals(descripcion, other.descripcion)
				&& esActivo == other.esActivo && Objects.equals(fabricante, other.fabricante)
				&& Objects.equals(id, other.id) && Objects.equals(iva, other.iva)
				&& Objects.equals(modelo, other.modelo) && Objects.equals(subtotal, other.subtotal)
				&& Objects.equals(total, other.total);
	}


	@Override
	public String toString() {
		return "StPayProducto [id=" + id + ", codProducto=" + codProducto + ", descripcion=" + descripcion
				+ ", fabricante=" + fabricante + ", iva=" + iva + ", modelo=" + modelo + ", subtotal=" + subtotal
				+ ", total=" + total + ", esActivo=" + esActivo + "]";
	}
	
}