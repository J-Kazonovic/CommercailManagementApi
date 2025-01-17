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
import com.stockmanager.fst.bean.Fournisseur;
import com.stockmanager.fst.model.dao.AchatDao;
import com.stockmanager.fst.model.service.facade.AchatItemService;
import com.stockmanager.fst.model.service.facade.AchatService;
import com.stockmanager.fst.model.service.facade.FactureService;
import com.stockmanager.fst.model.service.facade.FournisseurService;
import com.stockmanager.fst.security.entity.MyUser;
import com.stockmanager.fst.security.service.UserService;

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
	private UserService ps;
	@Autowired
	private FactureService fS;
	
	double total=0;
	
	@Override
	public Achat save(Achat achat, List<AchatItem> achatItems) {
		Achat demmandeFound=findByRef(achat.getRef());
		Fournisseur fr=fourn.findByNom(achat.getFournisseur().getNom());
		MyUser personnelDB = ps.findByName(achat.getComptable().getName());

		if(demmandeFound!=null) {
			return null;
		}else {
			achat.setDateCommande(new Date());
			achat.setComptable(personnelDB);
			achat.setFournisseur(fr);
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
			achat.setFournisseur(fr);
			achatDao.save(achat);
			aiS.valideAndsaveAI(achatItems, achat);
			return 1;
		}
		
		
	}


	@Override
	public int deleteById(Long id) {
		Achat achat=achatDao.findById(id).get();
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
	public Page<Achat> findAll(int page) {
		return achatDao.findAll(PageRequest.of(page, 8));
	}

	
	public void calculatTotal(List<AchatItem> items,Achat achat) {
		items.forEach(item->{
			total=total+(item.getQteCommander()*item.getProduit().getPrix());
		});
		
		achat.setTotal(total);
	}

	
	




}
