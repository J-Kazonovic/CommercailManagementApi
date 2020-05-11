package com.stockmanager.fst.model.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockmanager.fst.bean.BonDeCommande;
import com.stockmanager.fst.bean.BureauDeComptabilite;
import com.stockmanager.fst.bean.DemmandeDesPrix;
import com.stockmanager.fst.bean.DemmandeDesPrixItem;
import com.stockmanager.fst.model.service.facade.BonDeCommandeService;
import com.stockmanager.fst.model.service.facade.BureauDeComptabiliteService;
import com.stockmanager.fst.model.service.facade.DemmandeDesPrixItemService;
import com.stockmanager.fst.model.service.facade.DemmandeDesPrixService;

@RestController
@RequestMapping("/demmandeItem")
@CrossOrigin(value = "http://localhost:4200", maxAge = 3600)
public class DemmandeDesPrixItemRest {

	@Autowired
	private DemmandeDesPrixItemService dmmandeItemService;

	@PostMapping("/")
	public int save(@RequestBody DemmandeDesPrix demmande) {
		return dmmandeItemService.save(demmande, demmande.getDemmandeItem());
	}

	@GetMapping("/demmande/ref/{ref}")
	public List<DemmandeDesPrixItem> findByDemmandeRef(@PathVariable String ref) {
		return dmmandeItemService.findByDemmandeRef(ref);
	}

}
