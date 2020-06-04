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
public class Stock implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String ref;
	private double qteInitiale;
	@Temporal(TemporalType.DATE)
	private Date dateResu;
	@OneToMany(mappedBy = "stock")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private List<StockItem> stockItems;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateResu() {
		return dateResu;
	}

	public void setDateResu(Date dateResu) {
		this.dateResu = dateResu;
	}

	public List<StockItem> getStockItems() {
		return stockItems;
	}

	public void setStockItems(List<StockItem> stockItems) {
		this.stockItems = stockItems;
	}


	public double getQteInitiale() {
		return qteInitiale;
	}

	public void setQteInitiale(double qteInitiale) {
		this.qteInitiale = qteInitiale;
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
		Stock other = (Stock) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}

}
