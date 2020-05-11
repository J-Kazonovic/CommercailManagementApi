package com.stockmanager.fst.model.service.facade;


import java.util.List;

import com.stockmanager.fst.bean.Fournisseur;

public interface FournisseurService {
	public Fournisseur findByNom(String nom);

	public int save(Fournisseur fournisseur);
    public List<Fournisseur> findAll();
	
}
