package com.stockmanager.fst.model.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stockmanager.fst.bean.BonDeCommande;
import com.stockmanager.fst.bean.BureauDeComptabilite;
import com.stockmanager.fst.bean.Facture;
import com.stockmanager.fst.model.dao.BonDeCommandeDao;
import com.stockmanager.fst.model.dao.BureauDeComptabiliteDao;
import com.stockmanager.fst.model.dao.FactureDao;
import com.stockmanager.fst.model.service.facade.BonDeCommandeService;
import com.stockmanager.fst.model.service.facade.BureauDeComptabiliteService;
import com.stockmanager.fst.model.service.facade.FactureService;

@Service
public class FactureServiceImpl implements FactureService {

	@Autowired
	private FactureDao factureDao;

	@Override
	public Facture findByNum(Long num) {
		return factureDao.findByNum(num);
	}

	@Override
	@Transactional
	public int deleteByNum(Long num) {
		return factureDao.deleteByNum(num);
	}

	@Override
	public int save(Facture facture) {
		Facture factureFound=findByNum(facture.getNum());
		if(factureFound!=null) {
			return -1;
		}else {
			factureDao.save(facture);
			return 1;
		}
	}

	@Override
	public List<Facture> findByComptableLibelle(String libelle) {
		return factureDao.findByComptableLibelle(libelle);
	}

	@Override
	public List<Facture> findByFournisseurNom(String nom) {
		return factureDao.findByFournisseurNom(nom);
	}







}
