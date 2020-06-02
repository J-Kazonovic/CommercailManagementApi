package com.stockmanager.fst.model.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stockmanager.fst.bean.Achat;
import com.stockmanager.fst.bean.ExpressionBesoin;
import com.stockmanager.fst.bean.Stock;

@Repository
public interface StockDao extends JpaRepository<Stock, Long> {
	public Stock findByRef(String ref);
	List<Stock> findByDateResu(Date dateResu);

}
