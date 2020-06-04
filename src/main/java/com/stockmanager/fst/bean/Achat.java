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

import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.stockmanager.fst.model.service.util.Statuts;

@Entity
public class Achat implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String ref;
	private String modePaiment;
	
	//@Column(columnDefinition = "boolean default"+Statuts.DEMMANDE_BROUILLON)
	private String statut;

	@Temporal(TemporalType.DATE)
	private Date dateCommande;// Date De Creation

	@Temporal(TemporalType.DATE)
	private Date dateLivraison;// Date fin de livraison

	@ManyToOne
	private Personnel comptable;

	@ManyToOne
	private Fournisseur fournisseur;

	@OneToMany(mappedBy = "achat") 
	private List<AchatItem> achatItems;
	
	@OneToMany(mappedBy = "achat") 
	private List<Paiement> paiments;

	private double total;// Total Si l'achat devient une Bon de Commande
	private double totalPaier;// totalPaier=totalPaier + montentPaiment
	private double totalRester;// totalRester=total-totalPaier

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getTotalPaier() {
		return totalPaier;
	}

	public void setTotalPaier(double totalPaier) {
		this.totalPaier = totalPaier;
	}

	public double getTotalRester() {
		return totalRester;
	}

	public void setTotalRester(double totalRester) {
		this.totalRester = totalRester;
	}

	public Personnel getComptable() {
		return comptable;
	}

	public void setComptable(Personnel comptable) {
		this.comptable = comptable;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	public Date getDateLivraison() {
		return dateLivraison;
	}

	public void setDateLivraison(Date dateLivraison) {
		this.dateLivraison = dateLivraison;
	}

	public String getModePaiment() {
		return modePaiment;
	}

	public void setModePaiment(String modePaiment) {
		this.modePaiment = modePaiment;
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	public List<AchatItem> getAchatItems() {
		return achatItems;
	}

	public void setAchatItems(List<AchatItem> achatItem) {
		this.achatItems = achatItem;
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
		Achat other = (Achat) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Achat() {
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
