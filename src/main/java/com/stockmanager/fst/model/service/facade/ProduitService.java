package com.stockmanager.fst.model.service.facade;

import java.util.List;

import org.springframework.data.domain.Page;

import com.stockmanager.fst.bean.Produit;

public interface ProduitService {
	
	int save(Produit produit);
	int update(Produit produit);
	int delete(Long id);

	Produit findByRef(String ref);
	Produit findByLibelle(String libelle);

	List<Produit> findByCatLibelle(String libelle);
	Page<Produit> findAll(int page);

}
