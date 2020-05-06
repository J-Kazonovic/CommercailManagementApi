package com.stockmanager.fst.model.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stockmanager.fst.bean.BonDeCommande;
import com.stockmanager.fst.bean.BureauDeComptabilite;
import com.stockmanager.fst.bean.Devis;
import com.stockmanager.fst.bean.Facture;
import com.stockmanager.fst.model.dao.BonDeCommandeDao;
import com.stockmanager.fst.model.dao.BureauDeComptabiliteDao;
import com.stockmanager.fst.model.dao.DevisDao;
import com.stockmanager.fst.model.dao.FactureDao;
import com.stockmanager.fst.model.service.facade.BonDeCommandeService;
import com.stockmanager.fst.model.service.facade.BureauDeComptabiliteService;
import com.stockmanager.fst.model.service.facade.DevisService;
import com.stockmanager.fst.model.service.facade.FactureService;

@Service
public class DevisServiceImpl implements DevisService {

	@Autowired
	private DevisDao devisDao;

	@Override
	public Devis findByNumero(Long numero) {
		return devisDao.findByNumero(numero);
	}

	@Override
	@Transactional
	public int deleteByNumero(Long numero) {
		return devisDao.deleteByNumero(numero);
	}

	@Override
	public int save(Devis devis) {
		Devis devisFound=findByNumero(devis.getNumero());
		if(devisFound!=null) {
			return -1;
		}else {
			devisDao.save(devis);
			return 1;
		}
	}

	@Override
	public List<Devis> findByComptableLibelle(String libelle) {
		return devisDao.findByComptableLibelle(libelle);
	}

	@Override
	public List<Devis> findByFournisseurNom(String nom) {
		return devisDao.findByFournisseurNom(nom);
	}







}
