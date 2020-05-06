package com.stockmanager.fst.model.service.facade;


import com.stockmanager.fst.bean.BureauDeComptabilite;

public interface BureauDeComptabiliteService {

	public BureauDeComptabilite findByLibelle(String libelle);

	public int deleteByLibelle(String libelle);

	public int save(BureauDeComptabilite bureauDeComptabilite);

	
}
