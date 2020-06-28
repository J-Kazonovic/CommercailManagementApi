package com.stockmanager.fst.model.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stockmanager.fst.bean.Achat;
import com.stockmanager.fst.bean.Facture;
import com.stockmanager.fst.model.dao.FactureDao;
import com.stockmanager.fst.model.service.facade.AchatService;
import com.stockmanager.fst.model.service.facade.FactureService;

@Service
@Transactional
public class FactureServiceImpl implements FactureService {
	
	@Autowired
	private AchatService aS;

	@Autowired
	private FactureDao factureDao;

	@Override
	public int save(Facture facture) {
		Achat achat=aS.findByRef(facture.getAchat().getRef());
		Facture fr=findByRef(facture.getRef());
		if(fr!=null) {
			return -1;
		}else {
			facture.setAchat(achat);
			factureDao.save(facture);
			return 1;
		}

	}
	
	@Override
	public int update(Facture facture) {
		Achat achat=aS.findByRef(facture.getAchat().getRef());
		Facture fr=factureDao.findById(facture.getId()).get();
		if(fr!=null) {
			facture.setAchat(achat);
			factureDao.save(facture);
			return 1;
		}else {
			return -1;
		}
	}

	@Override
	public int delete(Long id) {
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

	@Override
	public Facture findByAchatRef(String ref) {
		Achat achat=aS.findByRef(ref);
		return factureDao.findByAchatId(achat.getId());
	}
	
	
	
	
	



	

	
	




}
