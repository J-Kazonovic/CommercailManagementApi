package com.stockmanager.fst.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class AchatEbpItemsLink implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private AchatItem achatItem;
	
	@ManyToOne
	private ExpressionBesoinProduit ebp;

	
	
	
	public AchatEbpItemsLink() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AchatItem getAchatItem() {
		return achatItem;
	}

	public void setAchatItem(AchatItem achatItem) {
		this.achatItem = achatItem;
	}

	public ExpressionBesoinProduit getEbp() {
		return ebp;
	}

	public void setEbp(ExpressionBesoinProduit ebp) {
		this.ebp = ebp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AchatEbpItemsLink other = (AchatEbpItemsLink) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	

}
