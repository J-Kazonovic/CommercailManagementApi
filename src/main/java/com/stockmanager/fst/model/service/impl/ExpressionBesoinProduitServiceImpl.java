package com.stockmanager.fst.model.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockmanager.fst.bean.ExpressionBesoin;
import com.stockmanager.fst.bean.ExpressionBesoinProduit;
import com.stockmanager.fst.model.dao.ExpressionBesoinProduitDao;
import com.stockmanager.fst.model.service.facade.ExpressionBesoinProduitService;

@Service
public class ExpressionBesoinProduitServiceImpl implements ExpressionBesoinProduitService {
	@Autowired
	private ExpressionBesoinProduitDao expBsProDao;

	@Override
	public void valideAndsaveEBP(List<ExpressionBesoinProduit> exbProduit, ExpressionBesoin eb) {
		Iterator<ExpressionBesoinProduit> itr = exbProduit.iterator();
		while (itr.hasNext()) {
			ExpressionBesoinProduit expBP = itr.next();
			// Product Exist
			expBP.setEb(eb);
			expBsProDao.save(expBP);

		}
	}

	@Override
	public List<ExpressionBesoinProduit> findByEbId(Long ebID) {
		return expBsProDao.findByEbId(ebID);
	}

	@Override
	public int deleteByEbId(Long id) {
		expBsProDao.deleteByEbId(id);
		return 1;

	}

}
