package com.stockmanager.fst.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stockmanager.fst.bean.BonDeCommande;
import com.stockmanager.fst.bean.BureauDeComptabilite;

@Repository
public interface BonDeCommandeDao extends JpaRepository<BonDeCommande, Long> {

	public BonDeCommande findByRef(String ref);

	public int deleteByRef(String ref);
	public List<BonDeCommande> findByComptableLibelle(String libelle);
	public List<BonDeCommande> findByFournisseurNom(String nom);
}
