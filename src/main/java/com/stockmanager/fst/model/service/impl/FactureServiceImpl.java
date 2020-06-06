package com.stockmanager.fst.model.service.impl;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stockmanager.fst.bean.Achat;
import com.stockmanager.fst.bean.AchatItem;
import com.stockmanager.fst.bean.Facture;
import com.stockmanager.fst.bean.Fournisseur;
import com.stockmanager.fst.model.dao.AchatDao;
import com.stockmanager.fst.model.dao.FactureDao;
import com.stockmanager.fst.model.service.facade.AchatItemService;
import com.stockmanager.fst.model.service.facade.AchatService;
import com.stockmanager.fst.model.service.facade.FactureService;
import com.stockmanager.fst.model.service.facade.FournisseurService;
import com.stockmanager.fst.model.service.facade.PersonnelService;
import com.stockmanager.fst.model.service.util.Statuts;

@Service
@Transactional
public class FactureServiceImpl implements FactureService {

	@Autowired
	private FactureDao factureDao;

	@Override
	public int save(Facture facture) {
		Facture fr=findByRef(facture.getRef());
		if(fr!=null) {
			return -1;
		}else {
			factureDao.save(facture);
			return 1;
		}

	}

	@Override
	public int deleteById(Long id) {
		Facture fr=factureDao.findById(id).get();
		factureDao.deleteById(fr.getId());
		return 1;

	}

	@Override
	public Facture findByRef(String ref) {
		return factureDao.findByRef(ref);
	}

	@Override
	public List<Facture> findAll() {
		return factureDao.findAll();
	}
	

	
	




}
