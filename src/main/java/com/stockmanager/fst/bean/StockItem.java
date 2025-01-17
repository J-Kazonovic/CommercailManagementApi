package com.stockmanager.fst.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.stockmanager.fst.model.service.util.Statuts;

@Entity
public class StockItem implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String ref;
	private double qteStocke;
    private double qtAlerte;
    private double qtFinal;
	@ManyToOne
	private Produit produit;
	@ManyToOne
	private Stock stock;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public double getQteStocke() {
		return qteStocke;
	}

	public void setQteStocke(double qteStocke) {
		this.qteStocke = qteStocke;
	}

	public double getQtAlerte() {
		return qtAlerte;
	}

	public void setQtAlerte(double qtAlerte) {
		this.qtAlerte = qtAlerte;
	}

	public double getQtFinal() {
		return qtFinal;
	}

	public void setQtFinal(double qtFinal) {
		this.qtFinal = qtFinal;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
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
		StockItem other = (StockItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public StockItem() {
		super();
		// TODO Auto-generated constructor stub
	}

}
