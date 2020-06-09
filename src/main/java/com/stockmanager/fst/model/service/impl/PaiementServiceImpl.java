package com.stockmanager.fst.model.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockmanager.fst.bean.Achat;
import com.stockmanager.fst.bean.Facture;
import com.stockmanager.fst.bean.Paiement;
import com.stockmanager.fst.model.dao.PaiementDao;
import com.stockmanager.fst.model.service.facade.AchatService;
import com.stockmanager.fst.model.service.facade.FactureService;
import com.stockmanager.fst.model.service.facade.PaiementService;

@Service
public class PaiementServiceImpl implements PaiementService {
	
	@Autowired
	private FactureService fS;
	@Autowired
	private PaiementDao pDao;

	@Override
	public int save(Paiement p) {
		Facture factureDB=fS.findByRef(p.getFacture().getRef());
		if(factureDB==null) {
			return -1;
		}else {
			p.setFacture(factureDB);
			p.setPaiementDate(new Date());
			pDao.save(p);
			return 1;
		}
		
		
	}

	@Override
	public int update(Paiement p) {
		Facture achatDB=fS.findByRef(p.getFacture().getRef());
		if(achatDB==null) {
			return -1;
		}else {
			p.setFacture(achatDB);
			pDao.save(p);
			return 1;
		}
	}

	@Override
	public int delete(Long id) {
		pDao.deleteById(id);
		return 1;
	}

	@Override
	public List<Paiement> findAll() {
		return pDao.findAll();
	}

	@Override
	public List<Paiement> findByFactureRef(String ref) {
		return pDao.findByFactureRef(ref);
	}

}
