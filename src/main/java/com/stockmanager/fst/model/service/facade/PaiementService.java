package com.stockmanager.fst.model.service.facade;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stockmanager.fst.bean.Paiement;


public interface PaiementService {
	
	int save(Paiement p);
	int update(Paiement p);
	int delete(Long id);
	
	List<Paiement> findAll();
	List<Paiement> findByFactureRef(String ref);
	
	

}
