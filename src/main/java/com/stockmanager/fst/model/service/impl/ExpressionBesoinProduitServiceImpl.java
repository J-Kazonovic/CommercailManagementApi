package com.stockmanager.fst.model.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockmanager.fst.bean.ExpressionBesoin;
import com.stockmanager.fst.bean.ExpressionBesoinProduit;
import com.stockmanager.fst.bean.Produit;
import com.stockmanager.fst.model.dao.ExpressionBesoinProduitDao;
import com.stockmanager.fst.model.service.facade.ExpressionBesoinProduitService;
import com.stockmanager.fst.model.service.facade.ProduitService;

@Service
public class ExpressionBesoinProduitServiceImpl implements ExpressionBesoinProduitService {
	@Autowired
	private ProduitService ps;
	@Autowired
	private ExpressionBesoinProduitDao expBsProDao;

	@Override
	public void valideAndsaveEBP(List<ExpressionBesoinProduit> exbProduit, ExpressionBesoin eb) {
		Iterator<ExpressionBesoinProduit> itr = exbProduit.iterator();
		while (itr.hasNext()) {
			ExpressionBesoinProduit expBP = itr.next();
			Produit p=ps.findByLibelle(expBP.getProduit().getLibelle());
			// Product Exist
			expBP.setProduit(p);
			expBP.setEb(eb);
			expBsProDao.save(expBP);

		}
	}

	@Override
	public int deleteByEbpId(Long id) {
		expBsProDao.deleteById(id);
		return 1;
	}

	@Override
	public int deleteByEbId(Long id) {
		return expBsProDao.deleteByEbId(id);
	}
	
	
	@Override
	public List<ExpressionBesoinProduit> findByEbId(Long ebID) {
		return expBsProDao.findByEbId(ebID);
	}
	

	@Override
	public List<ExpressionBesoinProduit> findByAll() {
		return expBsProDao.findAll();
	}



}
