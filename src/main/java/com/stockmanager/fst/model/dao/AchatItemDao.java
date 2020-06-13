package com.stockmanager.fst.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stockmanager.fst.bean.AchatItem;

@Repository
public interface AchatItemDao extends JpaRepository<AchatItem, Long> {
	
    List<AchatItem> findByAchatRef(String ref);
    public int deleteByProduitLibelle(String libelle);
	
}
