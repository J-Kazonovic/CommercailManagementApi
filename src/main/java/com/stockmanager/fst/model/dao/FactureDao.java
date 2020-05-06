package com.stockmanager.fst.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stockmanager.fst.bean.Devis;
import com.stockmanager.fst.bean.Facture;

@Repository
public interface FactureDao extends JpaRepository<Facture, Long> {

	public Facture findByNum(Long num);

	public int deleteByNum(Long num);
	public List<Facture> findByComptableLibelle(String libelle);
	public List<Facture> findByFournisseurNom(String nom);

}
