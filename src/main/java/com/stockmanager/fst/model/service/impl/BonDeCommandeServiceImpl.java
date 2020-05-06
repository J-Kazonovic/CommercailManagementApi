package com.stockmanager.fst.model.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stockmanager.fst.bean.BonDeCommande;
import com.stockmanager.fst.bean.BureauDeComptabilite;
import com.stockmanager.fst.model.dao.BonDeCommandeDao;
import com.stockmanager.fst.model.dao.BureauDeComptabiliteDao;
import com.stockmanager.fst.model.service.facade.BonDeCommandeService;
import com.stockmanager.fst.model.service.facade.BureauDeComptabiliteService;

@Service
public class BonDeCommandeServiceImpl implements BonDeCommandeService {

	@Autowired
	private BonDeCommandeDao bonDeCommandeDao;

	@Override
	public BonDeCommande findByRef(String ref) {
		return bonDeCommandeDao.findByRef(ref);
	}

	@Override
	@Transactional
	public int deleteByRef(String ref) {
		return bonDeCommandeDao.deleteByRef(ref);
	}

	@Override
	public int save(BonDeCommande bonDeCommande) {
		BonDeCommande commandeFound=findByRef(bonDeCommande.getRef());
		if(commandeFound!=null) {
			return -1;
		}else {
			bonDeCommandeDao.save(bonDeCommande);
			return 1;
		}
	}

	@Override
	public List<BonDeCommande> findByComptableLibelle(String libelle) {
		return bonDeCommandeDao.findByComptableLibelle(libelle);
	}

	@Override
	public List<BonDeCommande> findByFournisseurNom(String nom) {
		return bonDeCommandeDao.findByFournisseurNom(nom);
	}





}
