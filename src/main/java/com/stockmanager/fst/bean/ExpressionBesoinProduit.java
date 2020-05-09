package com.stockmanager.fst.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ColumnDefault;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.stockmanager.fst.model.service.util.Statuts;

@Entity
public class ExpressionBesoinProduit implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Produit produit;
	
	@ManyToOne
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private ExpressionBesoin eb;
	
	private double qteDemande;
	private double qteAccorde;
	private double qteAchete;
	
	private String product_desc;
	
	
	private String besoin_statut;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDesc() {
		return product_desc;
	}
	public void setDesc(String desc) {
		this.product_desc = desc;
	}

	public ExpressionBesoin getEb() {
		return eb;
	}
	public void setEb(ExpressionBesoin eb) {
		this.eb = eb;
	}
	
	public String getBesoin_statut() {
		return besoin_statut;
	}
	public void setBesoin_statut(String besoin_statut) {
		this.besoin_statut = besoin_statut;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	public String getProduct_desc() {
		return product_desc;
	}
	public void setProduct_desc(String product_desc) {
		this.product_desc = product_desc;
	}
	public double getQteDemande() {
		return qteDemande;
	}
	public void setQteDemande(double qteDemande) {
		this.qteDemande = qteDemande;
	}
	public double getQteAccorde() {
		return qteAccorde;
	}
	public void setQteAccorde(double qteAccorde) {
		this.qteAccorde = qteAccorde;
	}
	public double getQteAchete() {
		return qteAchete;
	}
	public void setQteAchete(double qteAchete) {
		this.qteAchete = qteAchete;
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
		ExpressionBesoinProduit other = (ExpressionBesoinProduit) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	public ExpressionBesoinProduit() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
