package com.stockmanager.fst.model.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stockmanager.fst.bean.ExpressionBesoin;



@Repository
public interface ExpressionBesoinDao extends JpaRepository<ExpressionBesoin, Long> {
	ExpressionBesoin findByTitle(String title);
	List<ExpressionBesoin> findByPersonnelCin(String cin);
	List<ExpressionBesoin> findByDeptLibelle(String libelle);
	List<ExpressionBesoin> findBySaveDate(Date saveDate);
}
