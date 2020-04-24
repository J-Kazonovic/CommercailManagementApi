package com.stockmanager.fst.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stockmanager.fst.bean.Dept;
import com.stockmanager.fst.model.dao.DeptDao;
import com.stockmanager.fst.model.service.facade.EntiteAdmService;

@Service
public class EntiteAdmServiceImpl implements EntiteAdmService {

	@Autowired
	private DeptDao entiteAdmDao;

	@Override
	public Dept findByLibelle(String libelle) {
		return entiteAdmDao.findByLibelle(libelle);
	}

	@Override
	public List<Dept> findAll() {
		return entiteAdmDao.findAll();
	}

	@Override
	public int save(Dept entite) {
		Dept foundedEntite = findByLibelle(entite.getLibelle());

		if (foundedEntite != null)
			return -1;

		else {
			entiteAdmDao.save(entite);
			return 1;
		}
	}

	@Override
	@Transactional
	public int deleteByLibelle(String libelle) {
		return entiteAdmDao.deleteByLibelle(libelle);
	}

}
