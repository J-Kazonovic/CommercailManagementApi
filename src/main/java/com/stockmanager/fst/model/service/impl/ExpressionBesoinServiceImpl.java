package com.stockmanager.fst.model.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stockmanager.fst.bean.Dept;
import com.stockmanager.fst.bean.ExpressionBesoin;
import com.stockmanager.fst.bean.ExpressionBesoinProduit;
import com.stockmanager.fst.bean.Personnel;
import com.stockmanager.fst.model.dao.ExpressionBesoinDao;
import com.stockmanager.fst.model.service.facade.EntiteAdmService;
import com.stockmanager.fst.model.service.facade.ExpressionBesoinProduitService;
import com.stockmanager.fst.model.service.facade.ExpressionBesoinService;
import com.stockmanager.fst.model.service.facade.PersonnelService;

@Service
@Transactional
public class ExpressionBesoinServiceImpl implements ExpressionBesoinService {
	@Autowired
	private ExpressionBesoinDao expbDao;
	
	@Autowired
	private PersonnelService ps;
	
	@Autowired
	private EntiteAdmService es;

	@Autowired
	private ExpressionBesoinProduitService ebps;

	@Override
	public int saveEb(ExpressionBesoin expb) {

		// get The List Of Product - Test There Existing & Save EBP
		List<ExpressionBesoinProduit> exbProduit = expb.getEbp();
		expb.setPersonnel(ps.findByCin("C1"));
		expb.setDept(es.findByLibelle("d1"));;
		expb.setSaveDate(new Date());
		expbDao.save(expb);
		ebps.valideAndsaveEBP(exbProduit, expb);
		return 1;

	}

	@Override
	public int updateEb(ExpressionBesoin expb) {
		/* get The Personnel */

		// get The List Of Product - Test There Existing & Save EBP
		List<ExpressionBesoinProduit> exbProduit = expb.getEbp();
		expb.setLastUpDate(new Date());
		expbDao.save(expb);
		ebps.valideAndsaveEBP(exbProduit, expb);
		return 1;
	}

	@Override
	public int deleteById(Long id) {
		int res = ebps.deleteByEbId(id);
		expbDao.deleteById(id);
		return res;
	}


	@Override
	public List<ExpressionBesoin> getAllExpB() {
		return expbDao.findAll();
	}

	@Override
	public List<ExpressionBesoin> getByEntiteAdministrativeLibelle(String libelle) {
		return expbDao.findByDeptLibelle(libelle);
	}

	@Override
	public List<ExpressionBesoin> getByPersonnelCin(String cin) {
		return expbDao.findByPersonnelCin(cin);
	}

	@Override
	public List<ExpressionBesoin> getBySaveDate(Date saveDate) {
		return expbDao.findBySaveDate(saveDate);
	}
}
