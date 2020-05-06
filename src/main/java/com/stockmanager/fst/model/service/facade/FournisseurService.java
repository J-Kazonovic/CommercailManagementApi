package com.stockmanager.fst.model.service.facade;


import com.stockmanager.fst.bean.Fournisseur;

public interface FournisseurService {
	public Fournisseur findByNom(String nom);

	public int save(Fournisseur fournisseur);

	
}
