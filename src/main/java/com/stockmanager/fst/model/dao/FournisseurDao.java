package com.stockmanager.fst.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stockmanager.fst.bean.Fournisseur;

@Repository
public interface FournisseurDao extends JpaRepository<Fournisseur, Long> {

	public Fournisseur findByNom(String nom);
	public List<Fournisseur> findByNomContaining(String term);

	
}
