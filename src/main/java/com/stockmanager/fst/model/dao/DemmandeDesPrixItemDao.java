package com.stockmanager.fst.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stockmanager.fst.bean.BonDeCommande;
import com.stockmanager.fst.bean.BureauDeComptabilite;
import com.stockmanager.fst.bean.DemmandeDesPrix;
import com.stockmanager.fst.bean.DemmandeDesPrixItem;

@Repository
public interface DemmandeDesPrixItemDao extends JpaRepository<DemmandeDesPrixItem, Long> {
   public List<DemmandeDesPrixItem> findByDemmandeRef(String ref);
}
