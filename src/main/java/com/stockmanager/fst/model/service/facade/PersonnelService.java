package com.stockmanager.fst.model.service.facade;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.stockmanager.fst.bean.Personnel;


public interface PersonnelService {

	public Personnel findByCin(String cin);
	
	public List<Personnel> findAll();
	
	public List<Personnel> findByEntiteAdmLibelle(String libelle);
	}