package com.stockmanager.fst.model.service.facade;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;

import com.stockmanager.fst.bean.ExpressionBesoin;


public interface ExpressionBesoinService {

	int saveEb(ExpressionBesoin expb);
	int updateEb(ExpressionBesoin expb);
	int deleteById(Long id);
	ExpressionBesoin findByTitle(String title);
	Page<ExpressionBesoin> getAllExpB(int page);
	List<ExpressionBesoin> getByEntiteAdministrativeLibelle(String libelle);
	List<ExpressionBesoin> getByPersonnelCin(String cin);
	List<ExpressionBesoin> getBySaveDate(Date saveDate);
	
}
