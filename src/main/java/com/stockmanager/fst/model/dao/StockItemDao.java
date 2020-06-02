package com.stockmanager.fst.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stockmanager.fst.bean.Achat;
import com.stockmanager.fst.bean.Stock;
import com.stockmanager.fst.bean.StockItem;

@Repository
public interface StockItemDao extends JpaRepository<StockItem, Long> {
	int deleteByStockId(Long id);
	List<StockItem> findByStockRef(String ref);
	List<StockItem> findByProduitRef(String ref);
}
