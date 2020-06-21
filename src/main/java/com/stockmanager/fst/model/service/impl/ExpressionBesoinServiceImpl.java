package com.stockmanager.fst.model.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stockmanager.fst.bean.Dept;
import com.stockmanager.fst.bean.ExpressionBesoin;
import com.stockmanager.fst.bean.ExpressionBesoinProduit;
import com.stockmanager.fst.model.dao.ExpressionBesoinDao;
import com.stockmanager.fst.model.service.facade.DeptService;
import com.stockmanager.fst.model.service.facade.ExpressionBesoinProduitService;
import com.stockmanager.fst.model.service.facade.ExpressionBesoinService;
import com.stockmanager.fst.model.service.facade.PersonnelService;
import com.stockmanager.fst.model.service.util.Statuts;
import com.stockmanager.fst.security.entity.MyUser;
import com.stockmanager.fst.security.service.UserService;

@Service
@Transactional
public class ExpressionBesoinServiceImpl implements ExpressionBesoinService {
	@Autowired
	private ExpressionBesoinDao expbDao;

	@Autowired
	private UserService ps;

	@Autowired
	private DeptService ds;

	@Autowired
	private ExpressionBesoinProduitService ebps;

	@Override
	public int saveEb(ExpressionBesoin expb) {
		ExpressionBesoin expbDB = findByTitle(expb.getTitle());
		if (expbDB == null) {
			MyUser personnelDB = ps.findByName(expb.getPersonnel().getName());
			Dept deptDB = ds.findByLibelle(personnelDB.getDept().getLibelle());
			List<ExpressionBesoinProduit> exbProduit = expb.getEbp();
			expb.setPersonnel(personnelDB);
			expb.setDept(deptDB);
			expb.setSaveDate(new Date());
			expbDao.save(expb);
			ebps.valideAndsaveEBP(exbProduit, expb);
			return 1;
		} else {
			// User Doesn't Exist
			return -1;
		}

	}

	@Override
	public int updateEb(ExpressionBesoin expb) {
		ExpressionBesoin expbDB = expbDao.findById(expb.getId()).get();
		if (expbDB != null) {

			List<ExpressionBesoinProduit> exbProduit = expb.getEbp();
			expbDao.save(expb);
			ebps.valideAndsaveEBP(exbProduit, expb);
			return 1;
		} else {
			return 0;
		}

	}

	@Override
	public int deleteById(Long id) {
		ExpressionBesoin eb = expbDao.findById(id).get();
		ebps.deleteByEbId(eb.getId());
		expbDao.deleteById(eb.getId());
		return 1;
	}

	@Override
	public Page<ExpressionBesoin> getAllExpB(int page) {
		return expbDao.findAll(PageRequest.of(page, 8));
	}

	@Override
	public List<ExpressionBesoin> getByEntiteAdministrativeLibelle(String libelle) {
		return expbDao.findByDeptLibelle(libelle);
	}

	@Override
	public List<ExpressionBesoin> getByPersonnelCin(String name) {
		return expbDao.findByPersonnelName(name);
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
