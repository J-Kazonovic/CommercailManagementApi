package com.stockmanager.fst.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stockmanager.fst.bean.Produit;
import com.stockmanager.fst.model.dao.ProduitDao;
import com.stockmanager.fst.model.service.facade.ProduitService;

@Service
public class ProduitServiceImpl implements ProduitService {

	@Autowired
	private ProduitDao produitDao;



	@Override
	public List<Produit> findAll() {
		return produitDao.findAll();
	}

	@Override
	public int save(Produit produit) {
		Produit produitFound=findByLibelle(produit.getLibelle());
		if(produitFound!=null) {
			return -1;
		}else {
			produitDao.save(produit);
			return 1;
		}
	}

	@Override
	public Produit findByLibelle(String libelle) {
		return produitDao.findByLibelle(libelle);
	}

	@Override
	public List<Produit> findByCatLibelle(String libelle) {
		return produitDao.findByCatLibelle(libelle);
	}


}
