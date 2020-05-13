package com.stockmanager.fst.model.service.facade;


import java.util.List;

import com.stockmanager.fst.bean.BonDeCommande;
import com.stockmanager.fst.bean.DemmandeDesPrix;
import com.stockmanager.fst.bean.DemmandeDesPrixItem;

public interface DemmandeDesPrixService {
	public DemmandeDesPrix findByRef(String ref);

	public int save(DemmandeDesPrix demmande,List<DemmandeDesPrixItem> demmandeItems);

	public List<DemmandeDesPrix> findByFournisseurNom(String nom);
	
}
