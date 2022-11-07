package com.appl.java.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class StPayProductoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="COD_METADATA")
	private long codMetadata;

	@Column(name="MODEL_ID", length = 20)
	private String modelId;

	public StPayProductoPK() {
	}

	public long getCodMetadata() {
		return codMetadata;
	}

	public void setCodMetadata(long codMetadata) {
		this.codMetadata = codMetadata;
	}

	public String getModelId() {
		return modelId;
	}

	public void setModelId(String modelId) {
		this.modelId = modelId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codMetadata, modelId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof StPayProductoPK))
			return false;
		StPayProductoPK other = (StPayProductoPK) obj;
		return codMetadata == other.codMetadata && Objects.equals(modelId, other.modelId);
	}

	@Override
	public String toString() {
		return "StPayProductoPK [codMetadata=" + codMetadata + ", modelId=" + modelId + "]";
	}
	
}