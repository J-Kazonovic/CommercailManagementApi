package com.stockmanager.fst.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stockmanager.fst.bean.Achat;
import com.stockmanager.fst.bean.Facture;

@Repository
public interface FactureDao extends JpaRepository<Facture, Long> {
	Facture findByRef(String ref);
	Facture findByAchatId(Long id);
}
