package com.stockmanager.fst.model.service.facade;

import java.util.List;

import com.stockmanager.fst.bean.ExpressionBesoin;
import com.stockmanager.fst.bean.ExpressionBesoinProduit;


public interface ExpressionBesoinProduitService {
	void valideAndsaveEBP(List<ExpressionBesoinProduit> ebpS,ExpressionBesoin eb);
	List<ExpressionBesoinProduit> findByEbId(Long ebID);
	int deleteByEbId(Long id);
	int deleteByProduitLibelle(String libelle);

}
