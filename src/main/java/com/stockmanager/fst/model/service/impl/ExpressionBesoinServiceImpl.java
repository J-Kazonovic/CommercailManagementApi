package com.stockmanager.fst.model.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stockmanager.fst.bean.ExpressionBesoin;
import com.stockmanager.fst.bean.ExpressionBesoinProduit;
import com.stockmanager.fst.model.dao.ExpressionBesoinDao;
import com.stockmanager.fst.model.service.facade.DeptService;
import com.stockmanager.fst.model.service.facade.ExpressionBesoinProduitService;
import com.stockmanager.fst.model.service.facade.ExpressionBesoinService;
import com.stockmanager.fst.model.service.facade.PersonnelService;
import com.stockmanager.fst.model.service.util.Statuts;

@Service
@Transactional
public class ExpressionBesoinServiceImpl implements ExpressionBesoinService {
	@Autowired
	private ExpressionBesoinDao expbDao;
	
	@Autowired
	private PersonnelService ps;
	
	@Autowired
	private DeptService es;

	@Autowired
	private ExpressionBesoinProduitService ebps;

	@Override
	public int saveEb(ExpressionBesoin expb) {
		// get The List Of Product - Test There Existing & Save EBP
		List<ExpressionBesoinProduit> exbProduit = expb.getEbp();
		expb.setPersonnel(ps.findByCin("C2"));
		expb.setDept(es.findByLibelle("Informatique"));
		expb.setSaveDate(new Date());
		expbDao.save(expb);
		ebps.valideAndsaveEBP(exbProduit, expb);
		return 1;

	}

	@Override
	public int updateEb(ExpressionBesoin expb) {

		// get The List Of Product - Test There Existing & Save EBP
		List<ExpressionBesoinProduit> exbProduit = expb.getEbp();
		expb.setLastUpDate(new Date());
		expbDao.save(expb);
		ebps.valideAndsaveEBP(exbProduit, expb);
		return 1;
	}

	@Override
	public int deleteById(Long id) {
		ExpressionBesoin eb=expbDao.findById(id).get();
		if(eb.getStatut()==Statuts.EnDemande) {
			return -1;
		}else {
			ebps.deleteByEbId(eb.getId());
			expbDao.deleteById(eb.getId());
		    return 1;
		}
	}


	@Override
	public Page<ExpressionBesoin> getAllExpB(int page) {
		return expbDao.findAll(PageRequest.of(page, 2));
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

	@Override
	public ExpressionBesoin findByTitle(String title) {
		return expbDao.findByTitle(title);
	}
}
