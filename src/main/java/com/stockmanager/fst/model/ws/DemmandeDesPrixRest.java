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
import com.stockmanager.fst.model.service.facade.BonDeCommandeService;
import com.stockmanager.fst.model.service.facade.BureauDeComptabiliteService;
import com.stockmanager.fst.model.service.facade.DemmandeDesPrixService;

@RestController
@RequestMapping("/demmande")
@CrossOrigin(value = "http://localhost:4200", maxAge = 3600)
public class DemmandeDesPrixRest {

	@Autowired
	private DemmandeDesPrixService dmmandeService;

	@PostMapping("/")
	public int save(@RequestBody DemmandeDesPrix demmande) {
		return dmmandeService.save(demmande, demmande.getDemmandeItem());
	}

	@GetMapping("/ref/{ref}")
	public DemmandeDesPrix findByRef(@PathVariable String ref) {
		return dmmandeService.findByRef(ref);
	}

}
