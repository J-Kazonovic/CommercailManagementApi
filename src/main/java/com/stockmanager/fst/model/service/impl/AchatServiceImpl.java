package com.stockmanager.fst.model.service.impl;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stockmanager.fst.bean.Achat;
import com.stockmanager.fst.bean.AchatItem;
import com.stockmanager.fst.bean.Fournisseur;
import com.stockmanager.fst.model.dao.AchatDao;
import com.stockmanager.fst.model.service.facade.AchatItemService;
import com.stockmanager.fst.model.service.facade.AchatService;
import com.stockmanager.fst.model.service.facade.FournisseurService;
import com.stockmanager.fst.model.service.facade.PersonnelService;
import com.stockmanager.fst.model.service.util.Statuts;

@Service
@Transactional
public class AchatServiceImpl implements AchatService {

	@Autowired
	private AchatDao achatDao;
	@Autowired
	private AchatItemService aiS;
	@Autowired
	private FournisseurService fourn;
	@Autowired
	private PersonnelService ps;
	
	double total=0;
	
	@Override
	public Achat save(Achat achat, List<AchatItem> achatItems) {
		Achat demmandeFound=findByRef(achat.getRef());
		Fournisseur fr=fourn.findByNom(achat.getFournisseur().getNom());
		if(demmandeFound!=null) {
			return null;
		}else {
			achat.setDateCommande(new Date());
			achat.setComptable(ps.findByCin("C1"));
			achat.setFournisseur(fr);
			calculatTotal(achatItems, achat);
			
			
			Achat achatR=achatDao.save(achat);
			aiS.valideAndsaveAI(achatItems, achat);
			return achatR;
		}
	}
	
	@Override
	public int update(Achat achat, List<AchatItem> achatItems) {
		Achat achatDB=achatDao.findByRef(achat.getRef());
		Fournisseur fr=fourn.findByNom(achat.getFournisseur().getNom());
		if(achatDB==null) {
			return -1;
		}else {
			achat.setId(achatDB.getId());
			achat.setDateCommande(new Date());
			achat.setComptable(ps.findByCin("C1"));
			achat.setFournisseur(fr);
			calculatTotal(achatItems, achat);
			achatDao.save(achat);
			aiS.valideAndsaveAI(achatItems, achat);
			System.out.println(achat);
			return 1;
		}
		
		
	}


	@Override
	public int deleteById(Long id) {
		Achat achat=achatDao.findById(id).get();
		aiS.deleteByAchatId(achat.getId());
		achatDao.deleteById(achat.getId());
		return 1;
	}



	@Override
	public Achat findByRef(String ref) {
		return achatDao.findByRef(ref);
	}


	@Override
	public List<Achat> findByFournisseurNom(String nom) {
		return achatDao.findByFournisseurNom(nom);
	}


	@Override
	public List<Achat> findAll() {
		return achatDao.findAll();
	}

	
	public void calculatTotal(List<AchatItem> items,Achat achat) {
		
		items.forEach(item->{
			total=total+(item.getQteCommander()*item.getProduit().getPrix());
		});
		
		achat.setTotal(total);
	}

	
	




}
