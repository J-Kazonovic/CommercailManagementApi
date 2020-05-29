package com.stockmanager.fst.model.service.facade;

import java.util.List;

import com.stockmanager.fst.bean.Personnel;


public interface PersonnelService {

	public Personnel findByCin(String cin);
	
	public List<Personnel> findAll();
	
	public List<Personnel> findByEntiteAdmLibelle(String libelle);
	}