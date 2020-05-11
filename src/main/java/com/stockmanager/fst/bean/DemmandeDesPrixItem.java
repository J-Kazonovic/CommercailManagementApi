package com.stockmanager.fst.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class DemmandeDesPrixItem implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private double qteCommander;
	private double qteLivrer;
	@ManyToOne
	private DemmandeDesPrix demmande;
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
	public double getQteLivrer() {
		return qteLivrer;
	}
	public void setQteLivrer(double qteLivrer) {
		this.qteLivrer = qteLivrer;
	}
	public DemmandeDesPrix getDemmande() {
		return demmande;
	}
	public void setDemmande(DemmandeDesPrix demmande) {
		this.demmande = demmande;
	}

	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
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
		DemmandeDesPrixItem other = (DemmandeDesPrixItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	public DemmandeDesPrixItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
