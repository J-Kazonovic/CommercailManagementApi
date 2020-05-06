package com.stockmanager.fst.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stockmanager.fst.bean.BonDeCommande;
import com.stockmanager.fst.bean.Devis;

@Repository
public interface DevisDao extends JpaRepository<Devis, Long> {

	public Devis findByNumero(Long numero);

	public int deleteByNumero(Long numero);
	public List<Devis> findByComptableLibelle(String libelle);
	public List<Devis> findByFournisseurNom(String nom);

}
