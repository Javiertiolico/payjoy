package com.appl.java.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;


/**
 * The persistent class for the ST_PAY_PARAMETRO_VENDEDOR database table.
 * 
 */
@Entity
@Table(name="ST_PAY_PARAMETRO_VENDEDOR")
//@NamedQuery(name="StPayParametroVendedor.findAll", query="SELECT s FROM StPayParametroVendedor s")
public class StPayParametroVendedor implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private StPayParametroVendedorPK id;

	@Column(name="COD_TIPO_PERSONA")
	private String codTipoPersona;

	@Column(name="COD_VENDEDOR")
	private String codVendedor;

	private int empresa;

	@Column(name="SALESCLERK_NAME")
	private String salesclerkName;

	public StPayParametroVendedor() {
	}

	public StPayParametroVendedorPK getId() {
		return this.id;
	}

	public void setId(StPayParametroVendedorPK id) {
		this.id = id;
	}

	public String getCodTipoPersona() {
		return this.codTipoPersona;
	}

	public void setCodTipoPersona(String codTipoPersona) {
		this.codTipoPersona = codTipoPersona;
	}

	public String getCodVendedor() {
		return this.codVendedor;
	}

	public void setCodVendedor(String codVendedor) {
		this.codVendedor = codVendedor;
	}

	public int getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(int empresa) {
		this.empresa = empresa;
	}

	public String getSalesclerkName() {
		return this.salesclerkName;
	}

	public void setSalesclerkName(String salesclerkName) {
		this.salesclerkName = salesclerkName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codTipoPersona, codVendedor, empresa, id, salesclerkName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof StPayParametroVendedor))
			return false;
		StPayParametroVendedor other = (StPayParametroVendedor) obj;
		return Objects.equals(codTipoPersona, other.codTipoPersona) && Objects.equals(codVendedor, other.codVendedor)
				&& empresa == other.empresa && Objects.equals(id, other.id)
				&& Objects.equals(salesclerkName, other.salesclerkName);
	}

}