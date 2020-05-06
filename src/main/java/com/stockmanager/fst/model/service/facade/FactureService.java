package com.stockmanager.fst.model.service.facade;


import java.util.List;

import com.stockmanager.fst.bean.Facture;

public interface FactureService {
	public Facture findByNum(Long num);

	public int deleteByNum(Long num);

	public int save(Facture facture);
	public List<Facture> findByComptableLibelle(String libelle);
	public List<Facture> findByFournisseurNom(String nom);

	
}
