package com.stockmanager.fst.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stockmanager.fst.bean.Dept;
import com.stockmanager.fst.bean.Fournisseur;
import com.stockmanager.fst.model.dao.DeptDao;
import com.stockmanager.fst.model.dao.FournisseurDao;
import com.stockmanager.fst.model.service.facade.DeptService;
import com.stockmanager.fst.model.service.facade.FournisseurService;

@Service
public class FournisseurServiceImpl implements FournisseurService {

	@Autowired
	private FournisseurDao fournisseurDao;

	@Override
	public Fournisseur findByNom(String nom) {
		return fournisseurDao.findByNom(nom);
	}

	@Override
	public int save(Fournisseur fournisseur) {
		Fournisseur fournisseurFound=findByNom(fournisseur.getNom());
		if(fournisseurFound!=null) {
			return -1;
		}else {
			fournisseurDao.save(fournisseur);
			return 1;
		}
	}

	@Override
	public List<Fournisseur> findAll() {
		return fournisseurDao.findAll();
	}



}
