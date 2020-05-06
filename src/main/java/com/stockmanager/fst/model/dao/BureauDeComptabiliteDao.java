package com.stockmanager.fst.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stockmanager.fst.bean.BureauDeComptabilite;

@Repository
public interface BureauDeComptabiliteDao extends JpaRepository<BureauDeComptabilite, Long> {

	public BureauDeComptabilite findByLibelle(String libelle);

	public int deleteByLibelle(String libelle);

}
