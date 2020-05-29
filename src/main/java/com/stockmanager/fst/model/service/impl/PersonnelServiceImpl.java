package com.stockmanager.fst.model.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockmanager.fst.bean.Personnel;
import com.stockmanager.fst.model.dao.PersonnelDao;
import com.stockmanager.fst.model.service.facade.DeptService;
import com.stockmanager.fst.model.service.facade.PersonnelService;




@Service
public class PersonnelServiceImpl implements PersonnelService {

	@Autowired
	PersonnelDao personnelRepository;
	
	
	@Autowired
	DeptService entiteAdmService;
	

	@Override
	public Personnel findByCin(String cin) {

		return personnelRepository.findByCin(cin);
	}

	@Override
	public List<Personnel> findAll() {

		return personnelRepository.findAll();
	}

	@Override
	public List<Personnel> findByEntiteAdmLibelle(String libelle) {
		return personnelRepository.findByDeptLibelle(libelle);
	}

	
	
}

