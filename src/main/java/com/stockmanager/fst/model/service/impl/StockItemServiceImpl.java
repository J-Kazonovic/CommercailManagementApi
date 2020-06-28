package com.stockmanager.fst.model.service.impl;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockmanager.fst.bean.Produit;
import com.stockmanager.fst.bean.Stock;
import com.stockmanager.fst.bean.StockItem;
import com.stockmanager.fst.model.dao.StockItemDao;
import com.stockmanager.fst.model.service.facade.ProduitService;
import com.stockmanager.fst.model.service.facade.StockItemService;

@Service
public class StockItemServiceImpl implements StockItemService {

	@Autowired
	private StockItemDao stockItemDao;
	@Autowired
	private ProduitService ps;
	


	@Override
	public List<StockItem> findByStockRef(String ref) {
		return stockItemDao.findByStockRef(ref);
	}


	@Override
	public List<StockItem> findAll() {
		return stockItemDao.findAll();
	}


	@Override
	public int save(Stock stock, List<StockItem> stockItems) {
		for (StockItem stockItem : stockItems) {
			Produit produit = ps.findByLibelle(stockItem.getProduit().getLibelle());
			stockItem.setProduit(produit);
			stockItem.setStock(stock);
			stockItemDao.save(stockItem);
			
		}
		return 1;
	}


	@Override
	public List<StockItem> findByProduitRef(String ref) {
		return stockItemDao.findByProduitRef(ref);
	}


	@Override
	@Transactional
	public int deleteByProduitLibelle(String libelle) {
		int delProduit =stockItemDao.deleteByProduitLibelle(libelle);
		return delProduit;
	}
	
}
