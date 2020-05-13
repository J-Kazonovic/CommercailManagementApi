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
import com.stockmanager.fst.bean.Fournisseur;
import com.stockmanager.fst.model.dao.BonDeCommandeDao;
import com.stockmanager.fst.model.dao.BureauDeComptabiliteDao;
import com.stockmanager.fst.model.dao.DemmandeDesPrixDao;
import com.stockmanager.fst.model.service.facade.BonDeCommandeService;
import com.stockmanager.fst.model.service.facade.BureauDeComptabiliteService;
import com.stockmanager.fst.model.service.facade.DemmandeDesPrixService;
import com.stockmanager.fst.model.service.facade.FournisseurService;

@Service
public class DemmandeDesPrixServiceImpl implements DemmandeDesPrixService {

	@Autowired
	private DemmandeDesPrixDao demmandeDao;
	@Autowired
	private FournisseurService fourn;

	@Override
	public DemmandeDesPrix findByRef(String ref) {
		return demmandeDao.findByRef(ref);
	}

	@Override
	public int save(DemmandeDesPrix demmande, List<DemmandeDesPrixItem> demmandeItems) {
		DemmandeDesPrix demmandeFound=findByRef(demmande.getRef());
		Fournisseur fr=fourn.findByNom(demmande.getFournisseur().getNom());
		if(demmandeFound!=null) {
			return -1;
		}else {
			demmande.setFournisseur(fr);
			demmandeDao.save(demmande);
		}
		return 0;
	}

	@Override
	public List<DemmandeDesPrix> findByFournisseurNom(String nom) {
		return demmandeDao.findByFournisseurNom(nom);
	}

	




}
