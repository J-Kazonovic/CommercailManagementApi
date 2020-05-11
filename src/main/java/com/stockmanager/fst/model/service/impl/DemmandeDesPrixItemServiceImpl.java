package com.stockmanager.fst.model.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stockmanager.fst.bean.BonDeCommande;
import com.stockmanager.fst.bean.BureauDeComptabilite;
import com.stockmanager.fst.bean.DemmandeDesPrix;
import com.stockmanager.fst.bean.DemmandeDesPrixItem;
import com.stockmanager.fst.bean.ExpressionBesoin;
import com.stockmanager.fst.bean.Produit;
import com.stockmanager.fst.model.dao.BonDeCommandeDao;
import com.stockmanager.fst.model.dao.BureauDeComptabiliteDao;
import com.stockmanager.fst.model.dao.DemmandeDesPrixDao;
import com.stockmanager.fst.model.dao.DemmandeDesPrixItemDao;
import com.stockmanager.fst.model.service.facade.BonDeCommandeService;
import com.stockmanager.fst.model.service.facade.BureauDeComptabiliteService;
import com.stockmanager.fst.model.service.facade.DemmandeDesPrixItemService;
import com.stockmanager.fst.model.service.facade.DemmandeDesPrixService;
import com.stockmanager.fst.model.service.facade.ExpressionBesoinService;
import com.stockmanager.fst.model.service.facade.ProduitService;

@Service
public class DemmandeDesPrixItemServiceImpl implements DemmandeDesPrixItemService {

	@Autowired
	private DemmandeDesPrixItemDao demmandeItemDao;
	@Autowired
	private ProduitService produit;

	

	@Override
	public int save(DemmandeDesPrix demmande, List<DemmandeDesPrixItem> demmandeItems) {
		for (DemmandeDesPrixItem demmandeDesPrixItem : demmandeItems) {
			Produit p=produit.findByLibelle(demmandeDesPrixItem.getProduit().getLibelle());
			demmandeDesPrixItem.setProduit(p);
			demmandeItemDao.save(demmandeDesPrixItem);
			
		}
		return 1;
	}



	@Override
	public List<DemmandeDesPrixItem> findByDemmandeRef(String ref) {
		return demmandeItemDao.findByDemmandeRef(ref);
	}

	




}
