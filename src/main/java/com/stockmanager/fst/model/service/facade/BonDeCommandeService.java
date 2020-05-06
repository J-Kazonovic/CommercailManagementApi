package com.stockmanager.fst.model.service.facade;


import java.util.List;

import com.stockmanager.fst.bean.BonDeCommande;

public interface BonDeCommandeService {
	public BonDeCommande findByRef(String ref);

	public int deleteByRef(String ref);

	public int save(BonDeCommande bonDeCommande);
	public List<BonDeCommande> findByComptableLibelle(String libelle);
	public List<BonDeCommande> findByFournisseurNom(String nom);

	
}
