package com.stockmanager.fst.model.service.facade;


import java.util.List;

import com.stockmanager.fst.bean.AchatItem;
import com.stockmanager.fst.bean.Stock;
import com.stockmanager.fst.bean.StockItem;
import com.stockmanager.fst.bean.Achat;

public interface StockItemService {
	
	
	int save(Stock stock, List<StockItem> stockItems);
	int deleteByStockId(Long id);
	
	List<StockItem> findByStockRef(String ref);
	List<StockItem> findAll();
	List<StockItem> findByProduitRef(String ref);

	
}
