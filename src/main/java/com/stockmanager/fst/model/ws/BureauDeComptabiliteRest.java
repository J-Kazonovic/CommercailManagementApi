package com.stockmanager.fst.model.ws;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockmanager.fst.bean.BureauDeComptabilite;
import com.stockmanager.fst.model.service.facade.BureauDeComptabiliteService;

@RestController
@RequestMapping("/bureauDeComptabilite")
@CrossOrigin(value = "http://localhost:4200", maxAge = 3600)
public class BureauDeComptabiliteRest {

	@Autowired
	private BureauDeComptabiliteService comptableService;

	@GetMapping("/libelle/{libelle}")
	public BureauDeComptabilite findByLibelle(@PathVariable String libelle) {
		return comptableService.findByLibelle(libelle);
	}

	@DeleteMapping("/libelle/{libelle}")
	public int deleteByLibelle(@PathVariable String libelle) {
		return comptableService.deleteByLibelle(libelle);
	}

	@PostMapping("/")
	public int save(@RequestBody BureauDeComptabilite bureauDeComptabilite) {
		return comptableService.save(bureauDeComptabilite);
	}

}
