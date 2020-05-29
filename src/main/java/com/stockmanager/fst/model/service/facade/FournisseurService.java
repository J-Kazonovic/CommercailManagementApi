package com.stockmanager.fst.model.service.facade;


import java.util.List;

import com.stockmanager.fst.bean.Fournisseur;

public interface FournisseurService {
	
     int save(Fournisseur fournisseur);
     int update(Fournisseur fournisseur);
     int delete(Long id);
	 Fournisseur findByNom(String nom);
	 List<Fournisseur> findByNomContaining(String term);
     List<Fournisseur> findAll();
	
}
