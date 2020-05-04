package com.stockmanager.fst.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stockmanager.fst.bean.Produit;

@Repository
public interface ProduitDao extends JpaRepository<Produit, Long> {

	public Produit findByLibelle(String libelle);
	public List<Produit> findByCatLibelle(String libelle);

}
