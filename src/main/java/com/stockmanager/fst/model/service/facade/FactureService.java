package com.stockmanager.fst.model.service.facade;

import java.util.List;

import org.springframework.data.domain.Page;

import com.stockmanager.fst.bean.AchatItem;
import com.stockmanager.fst.bean.Facture;
import com.stockmanager.fst.bean.Achat;

public interface FactureService {

	int save(Facture facture);
	int update(Facture facture);
	int delete(Long id);

	List<Facture> findAll();
	Facture findByRef(String ref);
	Facture findByAchatRef(String ref);

	

}
