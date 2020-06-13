package com.stockmanager.fst.model.service.facade;


import java.util.List;

import com.stockmanager.fst.bean.AchatItem;
import com.stockmanager.fst.bean.Achat;

public interface AchatItemService {
	
	
	void valideAndsaveAI(List<AchatItem> achatItems, Achat achat);
	int deleteByAchatItemId(Long id);
	public int deleteByProduitLibelle(String libelle);
	
	List<AchatItem> findByAchatRef(String ref);
	List<AchatItem> findAll();


	
}
