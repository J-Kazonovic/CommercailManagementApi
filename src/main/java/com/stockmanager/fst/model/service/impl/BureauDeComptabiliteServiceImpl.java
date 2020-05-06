package com.stockmanager.fst.model.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stockmanager.fst.bean.BureauDeComptabilite;
import com.stockmanager.fst.model.dao.BureauDeComptabiliteDao;
import com.stockmanager.fst.model.service.facade.BureauDeComptabiliteService;

@Service
public class BureauDeComptabiliteServiceImpl implements BureauDeComptabiliteService {

	@Autowired
	private BureauDeComptabiliteDao comptableDao;

	@Override
	public BureauDeComptabilite findByLibelle(String libelle) {
		return comptableDao.findByLibelle(libelle);
	}

	@Override
	@Transactional
	public int deleteByLibelle(String libelle) {
		return comptableDao.deleteByLibelle(libelle);
	}

	@Override
	public int save(BureauDeComptabilite bureauDeComptabilite) {
		BureauDeComptabilite comptableFound=findByLibelle(bureauDeComptabilite.getLibelle());
		if(comptableFound!=null) {
			return -1;
		}else {
			comptableDao.save(bureauDeComptabilite);
			return 1;
		}
	}



}
