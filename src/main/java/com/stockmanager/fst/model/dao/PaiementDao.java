package com.stockmanager.fst.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stockmanager.fst.bean.Paiement;

@Repository
public interface PaiementDao extends JpaRepository<Paiement, Long>{
	List<Paiement> findByAchatRef(String ref);


}
