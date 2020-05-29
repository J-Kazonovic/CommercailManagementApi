package com.stockmanager.fst.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stockmanager.fst.bean.Unite;
import com.stockmanager.fst.model.dao.UniteDao;
import com.stockmanager.fst.model.service.facade.UniteService;

@Service
public class UniteServiceImpl implements UniteService {

	@Autowired
	private UniteDao uniteDao;

	@Override
	public Unite findByLibelle(String libelle) {
		return uniteDao.findByLibelle(libelle);
	}

	@Override
	public List<Unite> findAll() {
		return uniteDao.findAll();
	}

	@Override
	public int save(Unite unite) {
		Unite categoryFaound=findByLibelle(unite.getLibelle());
		if(categoryFaound!=null) {
			return -1;
		}else {
			uniteDao.save(unite);
			return 1;
		}
	}

	@Override
	@Transactional
	public int deleteByLibelle(String libelle) {
		return uniteDao.deleteByLibelle(libelle);
	}


}
