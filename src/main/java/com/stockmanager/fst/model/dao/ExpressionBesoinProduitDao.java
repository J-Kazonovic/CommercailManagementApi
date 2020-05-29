package com.stockmanager.fst.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stockmanager.fst.bean.ExpressionBesoinProduit;



@Repository
public interface ExpressionBesoinProduitDao extends JpaRepository<ExpressionBesoinProduit, Long> {
	
	int deleteByEbId(Long id);
	
	List<ExpressionBesoinProduit> findByEbId(Long ebID);
	List<ExpressionBesoinProduit> findByEbDeptLibelle(String libelle);
	List<ExpressionBesoinProduit> findByProduitCatLibelle(String libelle);
	List<ExpressionBesoinProduit> findByProduitLibelle(String libelle);

	
}
