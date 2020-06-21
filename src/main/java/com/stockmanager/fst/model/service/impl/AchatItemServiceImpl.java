package com.stockmanager.fst.model.service.impl;


import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockmanager.fst.bean.Achat;
import com.stockmanager.fst.bean.AchatEbpItemsLink;
import com.stockmanager.fst.bean.AchatItem;
import com.stockmanager.fst.bean.ExpressionBesoinProduit;
import com.stockmanager.fst.bean.Produit;
import com.stockmanager.fst.model.dao.AchatEbpItemsLinkDao;
import com.stockmanager.fst.model.dao.AchatItemDao;
import com.stockmanager.fst.model.dao.ExpressionBesoinProduitDao;
import com.stockmanager.fst.model.service.facade.AchatItemService;
import com.stockmanager.fst.model.service.facade.ExpressionBesoinProduitService;
import com.stockmanager.fst.model.service.facade.ProduitService;
import com.stockmanager.fst.model.service.util.Statuts;

@Service
public class AchatItemServiceImpl implements AchatItemService {

	@Autowired
	private AchatItemDao achatItemDao;
	@Autowired
	private ExpressionBesoinProduitDao ebpS;
	@Autowired
	private AchatEbpItemsLinkDao linkDao;
	@Autowired
	private ProduitService ps;


	@Override
	public void valideAndsaveAI(List<AchatItem> achatItems, Achat achat) {
		Iterator<AchatItem> itr = achatItems.iterator();
		while (itr.hasNext()) {
			AchatItem achatItem = itr.next();
			Produit p=ps.findByLibelle(achatItem.getProduit().getLibelle());
			achatItem.setProduit(p);
			achatItem.setAchat(achat);
			achatItemDao.save(achatItem);
			setEbpsLink(achatItem.getEbLinks(), achatItem);
			if(achat.getStatut().equals(Statuts.COMMANDE)) {
				upDateEbp(achatItem);
			}
		}
	}

	

	public void setEbpsLink(List<AchatEbpItemsLink> ebpLinks,AchatItem achatItem) {
		Iterator<AchatEbpItemsLink> itr = ebpLinks.iterator();
		while (itr.hasNext()) {
			AchatEbpItemsLink link = itr.next();
			ExpressionBesoinProduit ebp=ebpS.findById(link.getEbp().getId()).get();
			link.setAchatItem(achatItem);
			link.setEbp(ebp);
			linkDao.save(link);
		}
		
	}
	
	void upDateEbp(AchatItem achatItem) {
		List<AchatEbpItemsLink> links=linkDao.findByAchatItemId(achatItem.getId());
		Iterator<AchatEbpItemsLink> itr = links.iterator();
		while (itr.hasNext()) {
			AchatEbpItemsLink link = itr.next();
			ExpressionBesoinProduit ebp=ebpS.findById(link.getEbp().getId()).get();
			ebp.setQteAchete(achatItem.getQteCommander());
			ebpS.save(ebp);
		}
	}

	@Override
	public int deleteByAchatItemId(Long id) {
		 achatItemDao.deleteById(id);
		 return 1;
	}

	@Override
	@Transactional
	public int deleteByProduitLibelle(String libelle) {
		int delProduit =achatItemDao.deleteByProduitLibelle(libelle);
		return delProduit;
	}

	
	@Override
	public List<AchatItem> findByAchatRef(String ref) {
		return achatItemDao.findByAchatRef(ref);
	}
	


	@Override
	public List<AchatItem> findAll() {
		return achatItemDao.findAll();
	}
	
}
