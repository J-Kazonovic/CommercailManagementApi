package com.stockmanager.fst.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockmanager.fst.bean.Fournisseur;
import com.stockmanager.fst.model.dao.FournisseurDao;
import com.stockmanager.fst.model.service.facade.FournisseurService;

@Service
public class FournisseurServiceImpl implements FournisseurService {

	@Autowired
	private FournisseurDao fournisseurDao;

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
	public int update(Fournisseur fournisseur) {
		Fournisseur fournisseurFound=fournisseurDao.findById(fournisseur.getId()).get();
		if(fournisseurFound!=null) {
			fournisseurDao.save(fournisseur);
			return 1;
		}else {
			return -1;
		}
	}
	
	@Override
	public int delete(Long id) {
		Fournisseur fournisseurFound=fournisseurDao.findById(id).get();
		if(fournisseurFound!=null) {
			fournisseurDao.deleteById(fournisseurFound.getId());
			return 1;
		}else {
			return -1;
		}

	}


	@Override
	public List<Fournisseur> findAll() {
		return fournisseurDao.findAll();
	}
	
	@Override
	public Fournisseur findByNom(String nom) {
		return fournisseurDao.findByNom(nom);
	}

	@Override
	public List<Fournisseur> findByNomContaining(String term) {
		return fournisseurDao.findByNomContaining(term);
	}




	


}
