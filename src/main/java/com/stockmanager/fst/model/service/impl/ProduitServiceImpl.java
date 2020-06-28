package com.stockmanager.fst.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.stockmanager.fst.bean.Category;
import com.stockmanager.fst.bean.Produit;
import com.stockmanager.fst.bean.Unite;
import com.stockmanager.fst.model.dao.ProduitDao;
import com.stockmanager.fst.model.service.facade.CategoryService;
import com.stockmanager.fst.model.service.facade.ProduitService;
import com.stockmanager.fst.model.service.facade.UniteService;

@Service
public class ProduitServiceImpl implements ProduitService {

	@Autowired
	private ProduitDao produitDao;
	@Autowired
	private CategoryService cS;
	@Autowired
	private UniteService uS;

	
	@Override
	public int save(Produit produit) {
		Produit produitFound=findByLibelle(produit.getLibelle());
		Category catDB=cS.findByLibelle(produit.getCat().getLibelle());
		Unite uniteDB=uS.findByLibelle(produit.getUnite().getLibelle());

		if(produitFound!=null) {
			return -1;
		}else {
			produit.setCat(catDB);
			produit.setUnite(uniteDB);
			produitDao.save(produit);
			return 1;
		}
	}
	
	@Override
	public int update(Produit produit) {
		Produit produitFound=produitDao.findById(produit.getId()).get();
		Category catDB=cS.findByLibelle(produit.getCat().getLibelle());
		Unite uniteDB=uS.findByLibelle(produit.getUnite().getLibelle());

		if(produitFound!=null) {
			produit.setCat(catDB);
			produit.setUnite(uniteDB);
			produitDao.save(produit);
			return 1;
		}else {
			
			return -1;
		}
	}
	
	@Override
	public int delete(Long id) {
		Produit pr=produitDao.findById(id).get();
		 produitDao.deleteById(pr.getId());
		 return 1;
	}

	
	@Override
	public Page<Produit> findAll(int page) {
		return produitDao.findAll(PageRequest.of(page, 8));
	}
	
	@Override
	public List<Produit> findByCatLibelle(String libelle) {
		return produitDao.findByCatLibelle(libelle);
	}
	
	@Override
	public Produit findByLibelle(String libelle) {
		return produitDao.findByLibelle(libelle);
	}
	
	@Override
	public Produit findByRef(String ref) {
		return produitDao.findByRef(ref);
	}

	
	



}
