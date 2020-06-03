package com.stockmanager.fst.model.service.facade;

import java.util.List;

import org.springframework.data.domain.Page;

import com.stockmanager.fst.bean.AchatItem;
import com.stockmanager.fst.bean.Achat;

public interface AchatService {

	Achat save(Achat achat, List<AchatItem> achatItems);
	int update(Achat achat, List<AchatItem> achatItems);
	int deleteById(Long id);

	
	Achat findByRef(String ref);
	Page<Achat> findAll(int page);	
	List<Achat> findByFournisseurNom(String nom);

}
