package com.stockmanager.fst.model.service.facade;

import java.util.List;

import com.stockmanager.fst.bean.Produit;

public interface ProduitService {

	public List<Produit> findByCatLibelle(String libelle);
	public List<Produit> findAll();
	public int deleteByLibelle(String libelle);
	public int save(Produit produit);
	public Produit findByLibelle(String libelle);
}
