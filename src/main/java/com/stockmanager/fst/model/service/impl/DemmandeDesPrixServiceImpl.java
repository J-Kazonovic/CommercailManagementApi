package com.stockmanager.fst.model.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stockmanager.fst.bean.BonDeCommande;
import com.stockmanager.fst.bean.BureauDeComptabilite;
import com.stockmanager.fst.bean.DemmandeDesPrix;
import com.stockmanager.fst.bean.DemmandeDesPrixItem;
import com.stockmanager.fst.bean.ExpressionBesoin;
import com.stockmanager.fst.model.dao.BonDeCommandeDao;
import com.stockmanager.fst.model.dao.BureauDeComptabiliteDao;
import com.stockmanager.fst.model.dao.DemmandeDesPrixDao;
import com.stockmanager.fst.model.service.facade.BonDeCommandeService;
import com.stockmanager.fst.model.service.facade.BureauDeComptabiliteService;
import com.stockmanager.fst.model.service.facade.DemmandeDesPrixService;

@Service
public class DemmandeDesPrixServiceImpl implements DemmandeDesPrixService {

	@Autowired
	private DemmandeDesPrixDao demmandeDao;

	@Override
	public DemmandeDesPrix findByRef(String ref) {
		return demmandeDao.findByRef(ref);
	}

	@Override
	public int save(DemmandeDesPrix demmande, List<DemmandeDesPrixItem> demmandeItems) {
		DemmandeDesPrix demmandeFound=findByRef(demmande.getRef());
		if(demmandeFound!=null) {
			return -1;
		}else {
			demmandeDao.save(demmande);
		}
		return 0;
	}

	




}
