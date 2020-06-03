package com.stockmanager.fst.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class AchatItem implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	private double unitPrice;
	private double totalPrice;// totalPrice=unitPrice*qteCommander
	private double qteCommander;
	private double qteRecu;
	
	
	@ManyToOne
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Achat achat;
	@ManyToOne
	private Produit produit;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public double getQteCommander() {
		return qteCommander;
	}
	public void setQteCommander(double qteCommander) {
		this.qteCommander = qteCommander;
	}
	public double getQteRecu() {
		return qteRecu;
	}
	public void setQteRecu(double qteLivrer) {
		this.qteRecu = qteLivrer;
	}
	public Achat getAchat() {
		return achat;
	}
	public void setAchat(Achat demmande) {
		this.achat = demmande;
	}

	
	
	
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
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
		AchatItem other = (AchatItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	public AchatItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
