package com.stockmanager.fst.model.service.facade;

import java.util.Date;
import java.util.List;

import com.stockmanager.fst.bean.AchatItem;
import com.stockmanager.fst.bean.Stock;
import com.stockmanager.fst.bean.StockItem;
import com.stockmanager.fst.bean.Achat;

public interface StockService {

	int save(Stock stock, List<StockItem> stockItems);
	List<Stock> findByDateResu(Date dateResu);
	int deleteById(Long id);

	Stock findByRef(String ref);

	List<Stock> findAll();

}
