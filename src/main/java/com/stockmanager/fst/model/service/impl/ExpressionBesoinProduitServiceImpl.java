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
import com.stockmanager.fst.model.service.util.Statuts;

@Service
public class ExpressionBesoinProduitServiceImpl implements ExpressionBesoinProduitService {
	@Autowired
	private ProduitService ps;
	@Autowired
	private ExpressionBesoinProduitDao ebpDao;

	@Override
	public void valideAndsaveEBP(List<ExpressionBesoinProduit> exbProduit, ExpressionBesoin eb) {
		Iterator<ExpressionBesoinProduit> itr = exbProduit.iterator();
		while (itr.hasNext()) {
			ExpressionBesoinProduit expBP = itr.next();
			Produit p=ps.findByLibelle(expBP.getProduit().getLibelle());
			// Product Exist
			expBP.setProduit(p);
			expBP.setEb(eb);
			ebpDao.save(expBP);

		}
	}
	


	@Override
	public int deleteByEbpId(Long id) {
	

		ebpDao.deleteById(id);
		return 1;
	}

	@Override
	public int deleteByEbId(Long id) {
		int i=0;
		List<ExpressionBesoinProduit> ebps=findByEbId(id);
		Iterator<ExpressionBesoinProduit> itr = ebps.iterator();
		while (itr.hasNext()) {
			if(itr.next().getBesoin_statut()==Statuts.Accorder) {
				i=-1;
				break;
			}
		}
		
		if(i==0) {
			return ebpDao.deleteByEbId(id);
		}else {
			return i;
		}
		
	}
	
	
	@Override
	public List<ExpressionBesoinProduit> findByEbId(Long ebID) {
		return ebpDao.findByEbId(ebID);
	}
	

	@Override
	public List<ExpressionBesoinProduit> findByAll() {
		return ebpDao.findAll();
	}



}
