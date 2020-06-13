package com.stockmanager.fst.model.service.impl;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stockmanager.fst.bean.Achat;
import com.stockmanager.fst.bean.AchatItem;
import com.stockmanager.fst.bean.Fournisseur;
import com.stockmanager.fst.bean.Stock;
import com.stockmanager.fst.bean.StockItem;
import com.stockmanager.fst.model.dao.AchatDao;
import com.stockmanager.fst.model.dao.StockDao;
import com.stockmanager.fst.model.service.facade.AchatItemService;
import com.stockmanager.fst.model.service.facade.AchatService;
import com.stockmanager.fst.model.service.facade.FournisseurService;
import com.stockmanager.fst.model.service.facade.PersonnelService;
import com.stockmanager.fst.model.service.facade.StockItemService;
import com.stockmanager.fst.model.service.facade.StockService;
import com.stockmanager.fst.model.service.util.Statuts;

@Service
@Transactional
public class StockServiceImpl implements StockService {

	@Autowired
	private StockDao stockDao;
	@Autowired
	private StockItemService stockI;

	@Autowired
	private PersonnelService ps;
	
	@Override
	public int save(Stock stock, List<StockItem> stockItems) {
		Stock stockFound=findByRef(stock.getRef());
		if(stockFound!=null) {
			return -1;
		}else {

			stock.setDateResu(new Date());
			stockDao.save(stock);
			stockI.save( stock,  stockItems);
			return 1;
		}
	}

	@Override
	public Stock findByRef(String ref) {
		return stockDao.findByRef(ref);
	}
	
	@Override
	public int deleteById(Long id) {
		Stock stock=stockDao.findById(id).get();
		stockDao.deleteById(stock.getId());
		return 1;
	}

	@Override
	public Page<Stock> findAll(int page) {
		return stockDao.findAll(PageRequest.of(page, 8));
	}

	@Override
	public List<Stock> findByDateResu(Date dateResu) {
		return stockDao.findByDateResu(dateResu);
	}
	@Override
	public int update(Stock stock, List<StockItem> stockItems) {
		Stock stockFound=findByRef(stock.getRef());
		if(stockFound==null) {
			return -1;
		}else {

			stock.setDateResu(new Date());
			stockDao.save(stock);
			stockI.save( stock,  stockItems);
			return 1;
		}
	}

	
	




}
