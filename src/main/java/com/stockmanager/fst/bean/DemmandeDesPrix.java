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
public class DemmandeDesPrix implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private String ref;
//	@ManyToOne
//	private Personnel comptable;
	@ManyToOne
	private Fournisseur fournisseur;
	@OneToMany(mappedBy = "demmande")
	private List<DemmandeDesPrixItem> demmandeItem;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}
	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	public List<DemmandeDesPrixItem> getDemmandeItem() {
		return demmandeItem;
	}
	public void setDemmandeItem(List<DemmandeDesPrixItem> demmandeItem) {
		this.demmandeItem = demmandeItem;
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
		DemmandeDesPrix other = (DemmandeDesPrix) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	public DemmandeDesPrix() {
		super();
		// TODO Auto-generated constructor stub
	}
//	public Personnel getComptable() {
//		return comptable;
//	}
//	public void setComptable(Personnel comptable) {
//		this.comptable = comptable;
//	}
	
	
}
